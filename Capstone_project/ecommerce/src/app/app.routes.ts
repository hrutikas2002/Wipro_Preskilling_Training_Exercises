import { Routes } from '@angular/router';

import { Register } from './components/register/register';
import { Login } from './components/login/login';
import { Home } from './components/home/home';
import { Productlist } from './components/productlist/productlist';
import { Productupdate } from './components/productupdate/productupdate';
import { Productdelete } from './components/productdelete/productdelete';
import { Productadd } from './components/productadd/productadd';
import { ProductCatalogue } from './components/product-catalogue/product-catalogue';
import { CartComponent } from './components/cart-component/cart-component';
import { adminGuard } from './adminGuard';
import { OrderHistory } from './components/order-history/order-history';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'login', component: Login },
  { path: 'register', component: Register },
  
  { path: 'products', canActivate:[adminGuard], component: Productlist },
  { path: 'productadd', component: Productadd },
  { path: 'productupdate/:id', component: Productupdate },
  { path: 'productdelete/:id', component: Productdelete },

  { path: 'user-dashboard', component: ProductCatalogue },
  { path: 'cart', component: CartComponent },

  {path:'orders',component: OrderHistory}
];
