import { ChangeDetectorRef, Component } from '@angular/core';
import { IProduct } from '../../interfaces/iproduct';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../../services/product-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-productupdate',
  imports: [FormsModule],
  templateUrl: './productupdate.html',
  styleUrl: './productupdate.css'
})
export class Productupdate {
  id: string | null = null;
  message: string | null = null;
  errorMessage: string | null = null;

  product: IProduct = {
    prodName: '',
    prodDesc: '',
    prodCat: '',
    make: '',
    availableQty: 0,
    price: 0,
    uom: '',
    prodRating: 0,
    imageURL: '',
    dateOfManufacture: ''
  };

  constructor(
    private activatedRoute: ActivatedRoute,
    private productService: ProductService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    console.log('==> ProductEdit Component Initialized');
    this.id = this.activatedRoute.snapshot.paramMap.get('id');

    if (this.id) {
      this.productService.findProduct(this.id).subscribe({
        next: (product) => {
          this.product = product;
          this.cdr.detectChanges();
        },
        error: (err) => {
          this.errorMessage = 'Failed to load product';
          console.error(err);
        }
      });
    }
  }

  saveProduct() {
    if (this.product) {
      this.productService.saveProduct(this.product).subscribe({
        next: () => {
          this.message = '✅ Product updated successfully!';
          this.errorMessage = null;

          // auto-navigate after 2 sec
          setTimeout(() => {
            this.router.navigate(['/products']);
          }, 2000);

          this.cdr.detectChanges();
        },
        error: (err) => {
          this.errorMessage = '❌ Failed to update product';
          this.message = null;
          console.error(err);
        }
      });
    }
  }
}