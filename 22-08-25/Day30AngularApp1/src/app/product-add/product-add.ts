import { ChangeDetectorRef, Component } from '@angular/core';
import { Router } from '@angular/router';
import { Productservice } from '../productservice';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-add',
  imports: [FormsModule],
  templateUrl: './product-add.html',
  styleUrl: './product-add.css',
})
export class ProductAdd {
  constructor(
    private productService: Productservice,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}
  name: string = '';
  category: string = '';
  price: number = 0;
  qty: number = 0;

  submit() {
    const newProduct = {
      name: this.name,
      category: this.category,
      price: this.price,
      qty: this.qty
    };

    console.log('Adding product:', newProduct);

    this.productService.addProduct(newProduct).subscribe(
      (response) => {
        console.log('Product added successfully:', response);
        this.name = '';
        this.category = '';
        this.price = 0;
        this.qty = 0;
        this.cdr.detectChanges();
        this.router.navigate(['/productlist']);
      },
      (error) => {
        console.error('Error adding product:', error);
      }
    );
  }
}
