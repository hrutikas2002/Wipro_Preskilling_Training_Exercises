import { ChangeDetectorRef, Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Productservice } from '../productservice';
import { IProduct } from '../iproduct';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-edit',
  imports: [FormsModule],
  templateUrl: './product-edit.html',
  styleUrl: './product-edit.css',
})
export class ProductEdit {
  constructor(
    private activatedRoute: ActivatedRoute,
    private productService: Productservice,
    private router: Router,
    private cdr: ChangeDetectorRef 
  ) {}

  id: string | null = null;
  product: IProduct = {
    name: '',
    category: '',
    price: 0,
    qty:0,
  };

  ngOnInit() {
    console.log('==> ProductEdit Component Initialized');
    // Get the product ID from route parameters
    this.id = this.activatedRoute.snapshot.paramMap.get('id');

    if (this.id) {
      this.productService.findProduct(this.id).subscribe((product) => {
        console.log(product);
        this.product = product;
        this.cdr.detectChanges();
      });
    }
  }

  saveProduct() {
    if (this.product) {
      this.productService.saveProduct(this.product).subscribe(() => {
        console.log('Product updated successfully');
        this.cdr.detectChanges();
        this.router.navigate(['/productlist']); // go back to list
      });
    }
  }
}
