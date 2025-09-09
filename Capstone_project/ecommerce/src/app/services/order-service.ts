import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IOrder } from '../interfaces/iorder';
import { OrderResponse } from '../interfaces/order-response';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseUrl = 'http://localhost:9191/order';

  constructor(private http: HttpClient) {}

  // POST /order  body: { userId }
  createOrder(userId: number): Observable<OrderResponse> {
    return this.http.post<OrderResponse>(this.baseUrl, { userId });
  }

  // PUT /order/{orderId}
  cancelOrder(orderId: number): Observable<void> {
    return this.http.put<void>(`${this.baseUrl}/${orderId}`, {});
  }

  getMyOrders(): Observable<IOrder[]> {
  return this.http.get<IOrder[]>(`${this.baseUrl}/${history}`);
}
}
