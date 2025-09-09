import { ChangeDetectorRef, Component } from '@angular/core';
import { IProduct } from '../../interfaces/iproduct';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../services/product-service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-productlist',
  imports: [CommonModule, RouterModule],
  templateUrl: './productlist.html',
  styleUrl: './productlist.css'
})
export class Productlist {
  products: IProduct[] = [];

  constructor(private productService: ProductService, private cdr: ChangeDetectorRef, ) {}

  ngOnInit(): void {
    this.loadProducts();
  }

   loadProducts() {
    this.productService.getProducts().subscribe(res => {
      this.products = res;
      this.cdr.detectChanges(); // update UI instantly
    });
  }
}
