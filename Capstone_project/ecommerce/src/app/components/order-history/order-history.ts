import { Component } from '@angular/core';
import { OrderService } from '../../services/order-service';
import { CommonModule, DatePipe, DecimalPipe } from '@angular/common';
import { IOrder } from '../../interfaces/iorder';

@Component({
  selector: 'app-order-history',
  imports: [CommonModule,DecimalPipe,DatePipe],
  templateUrl: './order-history.html',
  styleUrl: './order-history.css',
})
export class OrderHistory {
  orders: IOrder[] = [];
  loading = true;
  error = '';

  constructor(private orderSvc: OrderService) {

  }
  
  ngOnInit() {
    this.orderSvc.getMyOrders().subscribe({
      next: (res) => { this.orders = res ?? []; this.loading = false; },
      error: () => { this.error = 'Failed to load orders'; this.loading = false; },
    });
  }
}
