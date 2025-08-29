import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class User {
  private baseUrl = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {}

  register(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, user);
  }

  login(userId: string, password: string): Observable<any> {
    let params = new HttpParams()
      .set('userId', userId)
      .set('password', password);

    return this.http.post(`${this.baseUrl}/login`, {}, { params, responseType: 'text' });
  }
}
