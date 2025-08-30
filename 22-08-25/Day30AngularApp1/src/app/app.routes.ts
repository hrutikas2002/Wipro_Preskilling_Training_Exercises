import { Routes } from '@angular/router';
import { ProductList } from './product-list/product-list';
import { ProductAdd } from './product-add/product-add';
import { ProductEdit } from './product-edit/product-edit';
import { ProductDelete } from './product-delete/product-delete';
import { OrderProduct } from './order-product/order-product';
import { OrderHistory } from './order-history/order-history';

export const routes: Routes = [
  { path: '', component: ProductList },
  { path: 'productlist', component: ProductList },
  { path: 'productadd', component: ProductAdd },
  { path: 'productedit/:id', component: ProductEdit },
  { path: 'productdelete/:id', component: ProductDelete },

  // new routes for orders
  { path: 'order', component: OrderProduct },
  { path: 'orderhistory', component: OrderHistory },
];
