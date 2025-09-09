import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { DecodedToken } from '../interfaces/decoded-token';
import { jwtDecode } from 'jwt-decode';
import { Token } from '../interfaces/token';

type JwtPayload = { sub?: string; uid?: number; role?: string; exp?: number; iat?: number };

@Injectable({ providedIn: 'root' })
export class UserServices {
  private baseUrl = 'http://localhost:9191/user'; // gateway

  constructor(private http: HttpClient, private router: Router) {}

  register(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, user);
  }

  login(credentials: { userId: string; passWord: string }): Observable<Token> {
    return this.http.post<Token>(`${this.baseUrl}/login`, credentials);
  }

  /** Save token under a single, consistent key: 'token'. Also keep 'jwtToken' for backward compatibility. */
  saveToken(token: string) {
    localStorage.setItem('token', token);
    localStorage.setItem('jwtToken', token); // compat with any old code
    try {
      const decoded = jwtDecode<JwtPayload>(token);
      if (decoded?.sub) localStorage.setItem('userId', decoded.sub);
      if (decoded?.uid != null) localStorage.setItem('numericUserId', String(decoded.uid)); // <-- uid (not id)
      if (decoded?.role) localStorage.setItem('role', decoded.role);
    } catch { /* ignore */ }
  }

  getToken(): string | null {
    return localStorage.getItem('token') || localStorage.getItem('jwtToken');
  }

  decodeToken(): JwtPayload | null {
    const token = this.getToken();
    try { return token ? jwtDecode<JwtPayload>(token) : null; } catch { return null; }
  }

  isLoggedIn(): boolean { return !!this.getToken(); }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('userId');
    localStorage.removeItem('numericUserId');
    localStorage.removeItem('role');
  }

  getUserId(): string | null { return localStorage.getItem('userId'); }

  getNumericUserId(): number | null {
    const v = localStorage.getItem('numericUserId');
    if (!v) return null;
    const n = Number(v);
    return Number.isFinite(n) ? n : null;
  }
}