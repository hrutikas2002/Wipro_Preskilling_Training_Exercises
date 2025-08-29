import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { DecodedToken } from '../interfaces/decoded-token';
import { jwtDecode } from 'jwt-decode';
import { Token } from '../interfaces/token';

@Injectable({
  providedIn: 'root'
})
export class UserServices {
  private baseUrl = 'http://localhost:9191/user'; // backend API

  
  constructor(private http: HttpClient, private router: Router) {}

  register(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, user);
  }

  login(credentials: { userId: string; passWord: string }): Observable<Token> {
    return this.http.post<Token>(`${this.baseUrl}/login`, credentials);
  }

  saveToken(token: string) {
    localStorage.setItem('jwtToken', token);

    // Decode and store userId separately for easy access
    const decoded = jwtDecode<DecodedToken>(token);
    if (decoded && decoded.sub) {
      localStorage.setItem('userId', decoded.sub);
    }
  }

  getToken() {
    return localStorage.getItem('jwtToken');
  }

  decodeToken(): DecodedToken | null {
    const token = this.getToken();
    return token ? jwtDecode<DecodedToken>(token) : null;
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  logout() {
    localStorage.removeItem('jwtToken'); // fixed key
    localStorage.removeItem('userId');   // also clear userId
  }

  getUserId(): string | null {
    return localStorage.getItem('userId');
  }
}
