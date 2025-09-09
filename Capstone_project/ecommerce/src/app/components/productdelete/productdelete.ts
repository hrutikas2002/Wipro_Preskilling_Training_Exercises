import { ChangeDetectorRef, Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../../services/product-service';

@Component({
  selector: 'app-productdelete',
  imports: [],
   templateUrl: './productdelete.html',
  styleUrl: './productdelete.css'
})
export class Productdelete {
   
  id: string | null = null;
   message: string = '';   
  errorMessage: string = '';

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    console.log("Product to be deleted has id:", this.id);

    if (this.id) {
      const productId = Number(this.id);
      this.productService.deleteProduct(productId).subscribe(
        () => {
          this.message = '✅ Product deleted successfully!';
          setTimeout(() => {
            this.router.navigate(['/products']);
          }, 2000); // Navigate after showing message
          this.cdr.detectChanges();
        },
        error => {
          this.errorMessage = '❌ Error deleting product: ' + error.message;
          this.cdr.detectChanges();
        }
      );
    }
  }
}
