import { ChangeDetectorRef, Component } from '@angular/core';
import { IProduct } from '../../interfaces/iproduct';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../services/product-service';

@Component({
  selector: 'app-productlist',
  imports: [CommonModule],
  templateUrl: './productlist.html',
  styleUrl: './productlist.css'
})
export class Productlist {
  products: IProduct[] = [];

  constructor(private productService: ProductService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadProducts();
  }

   loadProducts() {
    this.productService.getProducts().subscribe(res => {
      this.products = res;
      this.cdr.detectChanges(); // update UI instantly
    });
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.loadProducts(); // reload after delete
    });
  }
}
