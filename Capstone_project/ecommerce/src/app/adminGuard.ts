import { inject } from '@angular/core';
import { CanActivateFn, Router, UrlTree } from '@angular/router';
import { jwtDecode } from 'jwt-decode';

export const adminGuard: CanActivateFn = (): boolean | UrlTree => {
  const token = localStorage.getItem('token') || localStorage.getItem('jwtToken');
  const router = inject(Router);
  if (!token) return router.parseUrl('/login');

  try {
    const payload = jwtDecode<any>(token);
    return payload?.role === 'ROLE_ADMIN' ? true : router.parseUrl('/user-dashboard');
  } catch {
    return router.parseUrl('/login');
  }
};
