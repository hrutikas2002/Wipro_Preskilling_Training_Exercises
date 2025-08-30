import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-history',
  imports: [],
  templateUrl: './order-history.html',
  styleUrl: './order-history.css'
})
export class OrderHistory implements OnInit{
  orders: any[] = [];

  constructor(private http: HttpClient, private cdr: ChangeDetectorRef, private router: Router) {}

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/orders/history').subscribe(data => {
      this.orders = data;
      this.cdr.detectChanges();
    });
  }

  goHome(){
    this.router.navigate(['/productlist']);
  }
}
