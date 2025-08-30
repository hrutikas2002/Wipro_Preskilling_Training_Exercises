import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-product',
  imports: [FormsModule],
  templateUrl: './order-product.html',
  styleUrl: './order-product.css'
})
export class OrderProduct implements OnInit{

  products: any[] = [];
  selectedProductId: number = 0;
  purchaseQty: number = 0;
  errorMessage: string = '';
  successMessage: string = '';


  constructor(private http: HttpClient, private router: Router,private cdr: ChangeDetectorRef) {
    
  }

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/products').subscribe(data => {
      this.products = data;
      this.cdr.detectChanges();
    });
  }

  onProductSelect() {
    this.purchaseQty = 0;
    this.errorMessage = '';
  }

  placeOrder() {
    const selected = this.products.find(p => p.id == this.selectedProductId);

    if (!selected) {
      this.errorMessage = 'Please select a product';
      return;
    }

    if (this.purchaseQty <= 0) {
      this.errorMessage = 'Quantity must be greater than 0';
      return;
    }

    if (this.purchaseQty > selected.qty) {
      this.errorMessage = 'Not enough stock available';
      return;
    }

    this.http.post<any>(`http://localhost:8080/orders/place/${this.selectedProductId}?qty=${this.purchaseQty}`, {})
      .subscribe({
        next: (res) => {
      this.successMessage = res.message; // now shows proper success message
      this.ngOnInit();  // reload product list with updated qty
      // this.router.navigate(['/productlist']);
      this.cdr.detectChanges();
        },
        error: err => {
          this.errorMessage = err.error.message || 'Something went wrong';
        }
      });
  }

  goHome() {
  this.router.navigate(['/productlist']); // navigate to home/product list
}

}
