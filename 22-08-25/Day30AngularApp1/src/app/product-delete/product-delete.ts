import { ChangeDetectorRef, Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Productservice } from '../productservice';

@Component({
  selector: 'app-product-delete',
  imports: [],
  templateUrl: './product-delete.html',
  styleUrl: './product-delete.css'
})
export class ProductDelete {
  id: string | null = null;

  constructor(
    private activeRoute: ActivatedRoute,
    private productService: Productservice,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.id = this.activeRoute.snapshot.paramMap.get('id');
    console.log("Product to be deleted has id:", this.id);

    this.productService.deleteProduct(this.id!).subscribe(
      response => {
        console.log('Product deleted successfully');
        this.cdr.detectChanges(); 
        this.router.navigate(['/productlist']); // Navigate to product list after deletion
      },
      error => {
        console.error('Error deleting product:', error);
      }
    );
  }
}
