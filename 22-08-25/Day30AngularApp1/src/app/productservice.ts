import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IProduct } from './iproduct';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Productservice {
  constructor(private http: HttpClient) {}

  getProducts(): Observable<IProduct[]> {
    let url: string = 'http://localhost:8080/products';
    return this.http.get<IProduct[]>(url);
  }

  addProduct(product: IProduct): Observable<IProduct> {
    let url: string = 'http://localhost:8080/products';
    return this.http.post<IProduct>(url, product);
  }
  deleteProduct(id: string): Observable<void> {
    let url: string = `http://localhost:8080/products/${id}`;
    return this.http.delete<void>(url);
  }

  findProduct(id: string): Observable<IProduct> {
    let url: string = `http://localhost:8080/products/${id}`;
    return this.http.get<IProduct>(url);
  }

  saveProduct(product: IProduct): Observable<IProduct> {
    let url: string = `http://localhost:8080/products/${product.id}`;
    return this.http.put<IProduct>(url, product);
  }
}
