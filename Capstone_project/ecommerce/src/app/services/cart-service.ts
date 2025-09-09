import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../interfaces/cart';
import { CartDetail } from '../interfaces/cart-detail';

@Injectable({ providedIn: 'root' })
export class CartService {
  private baseUrl = 'http://localhost:9191/cart'; // API Gateway

  constructor(private http: HttpClient) {}

  /** --- Token-driven endpoints (recommended) --- */

  /** GET /cart/me -> the logged-in user's cart (derived from JWT) */
  getMyCart(): Observable<CartDetail> {
    return this.http.get<CartDetail>(`${this.baseUrl}/me`);
  }

  /** POST /cart/addProd -> backend derives userId from JWT; body is only product/qty */
  addToMyCart(productId: number, quantity: number = 1): Observable<Cart> {
    return this.http.post<Cart>(`${this.baseUrl}/addProd`, { productId, quantity });
  }

  /** PUT /cart/update -> backend derives userId from JWT; body is product/qty */
  updateMyQuantity(productId: number, quantity: number): Observable<Cart> {
    return this.http.put<Cart>(`${this.baseUrl}/update`, { productId, quantity });
  }

  /** DELETE /cart/deleteProd/{itemid} -> remove a line by item id */
  removeItem(itemId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteProd/${itemId}`);
  }

  /** --- Legacy methods (safe to delete once backend is updated) --- */
  // getCart(userId: number): Observable<Cart> { return this.http.get<Cart>(`${this.baseUrl}/${userId}`); }
  // addToCart(userId: number, productId: number, quantity: number): Observable<Cart> {
  //   return this.http.post<Cart>(`${this.baseUrl}/addProd`, { userId, productId, quantity });
  // }
  // updateQuantity(userId: number, productId: number, quantity: number): Observable<Cart> {
  //   return this.http.put<Cart>(`${this.baseUrl}/update`, { userId, productId, quantity });
  // }
}
