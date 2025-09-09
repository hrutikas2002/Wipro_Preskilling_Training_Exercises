import { ChangeDetectorRef, Component } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { CartService } from '../../services/cart-service';
import { IProduct } from '../../interfaces/iproduct';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServices } from '../../services/user';

@Component({
  selector: 'app-product-catalogue',
  imports: [FormsModule],
  templateUrl: './product-catalogue.html',
  styleUrl: './product-catalogue.css'
})
export class ProductCatalogue {
  products: IProduct[] = [];
  allProducts: IProduct[] = [];
  searchText = '';
  category = '';

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private cdr: ChangeDetectorRef,
    private router: Router,
    private userService: UserServices
  ) {}

  private get uid(): number {
    const id = this.userService.getNumericUserId();
    if (id == null) { alert('Please login again'); this.router.navigate(['/login']); throw new Error('Missing numeric user id'); }
    return id;
  }

  ngOnInit(): void { this.loadProducts(); }

  loadProducts() {
    this.productService.getProducts().subscribe(res => {
      this.allProducts = res;
      this.products = [...res];
      this.cdr.detectChanges();
    });
  }

  addToCart(productId: number, quantity: number = 1): void {
  this.cartService.addToMyCart(productId, quantity).subscribe({
    next: () => alert('Added to cart'),
    error: (e) => alert(`Failed to add to cart (status ${e?.status ?? 'n/a'}): ${e?.error?.message ?? e.message}`)
  });
}

  search(): void {
    const q = this.searchText.toLowerCase();
    const c = this.category.toLowerCase();
    this.products = this.allProducts.filter(p =>
      p.prodName.toLowerCase().includes(q) || p.prodCat.toLowerCase().includes(c)
    );
  }

  viewCart() { this.router.navigate(['/cart']); }
}