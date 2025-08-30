import { Routes } from '@angular/router';

import { Register } from './components/register/register';
import { Login } from './components/login/login';
import { Product } from './components/product/product';
import { AdminProduct } from './components/admin-product/admin-product';
import { Home } from './components/home/home';
import { Productlist } from './components/productlist/productlist';

export const routes: Routes = [
    { path: '', component: Home },
    { path: 'login', component: Login },
    { path: 'register', component: Register },
    { path: 'user-dashboard', component: Product },
  { path: 'products', component: Productlist }
]
