import { ChangeDetectorRef, Component } from '@angular/core';
import { CommonModule, DecimalPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CartService } from '../../services/cart-service';
import { OrderService } from '../../services/order-service';
import { UserServices } from '../../services/user';
import { IProduct } from '../../interfaces/iproduct';

// If you created these, import your enriched types:
import { CartDetail } from '../../interfaces/cart-detail';

type CartEntry = { itemId: number; productId: number; qty: number; product?: IProduct };

@Component({
  selector: 'app-cart-component',
  standalone: true,
  imports: [CommonModule, FormsModule, DecimalPipe],
  templateUrl: './cart-component.html',
  styleUrl: './cart-component.css',
})
export class CartComponent {
  cart!: CartDetail;                 // <-- enriched cart (id, userId, items, totalQty, subtotal)
  entries: CartEntry[] = [];
  message = '';

  constructor(
    private cartService: CartService,
    private orderService: OrderService,
    private userService: UserServices,
    private cdr: ChangeDetectorRef
  ) {}

  private get uid(): number {
    const id = this.userService.getNumericUserId();
    if (id == null) { this.message = 'Please login again.'; throw new Error('Missing numeric user id'); }
    return id;
  }

  ngOnInit() { this.loadCart(); }

  private loadCart() {
  this.cartService.getMyCart().subscribe({
    next: (detail: any) => {
      // detail has: { id, userId, items: [{itemId, productId, qty, product, lineTotal}], totalQty, subtotal }
      this.cart = detail;

      // Map correctly (and be backward-compatible if shape ever changes)
      this.entries = (detail.items || []).map((it: any) => ({
        itemId: it.itemId ?? it.id,           // fallback to id if older shape
        productId: it.productId,
        qty: it.qty ?? it.quantity ?? 1,      // prefer qty, fallback to quantity
        product: it.product                   // already provided by backend
      }));

      this.message = this.entries.length ? '' : 'Your cart is empty';
      this.cdr.detectChanges();
    },
    error: (e) => {
      this.entries = [];
      this.message = `Failed to load cart (${e.status})`;
      this.cdr.detectChanges();
    }
  });
}


  // Totals: use server values if present, otherwise compute
  get totalQty(): number {
  return (this.cart as any)?.totalQty ?? this.entries.reduce((s, e) => s + e.qty, 0);
}

get subtotal(): number {
  return (this.cart as any)?.subtotal
    ?? this.entries.reduce((s, e) => s + ((e.product?.price ?? 0) * e.qty), 0);
}

  onQtyChange(entry: CartEntry) { if (entry.qty < 1) entry.qty = 1; }

  applyQty(entry: CartEntry) {
    this.cartService.updateMyQuantity(entry.productId, entry.qty).subscribe({
      next: () => { this.message = 'Quantity updated'; this.loadCart(); },
      error: () => { this.message = 'Failed to update quantity'; this.cdr.detectChanges(); }
    });
  }

  remove(itemId: number) {
    this.cartService.removeItem(itemId).subscribe({
      next: () => { this.message = 'Item removed'; this.loadCart(); },
      error: () => { this.message = 'Failed to remove item'; this.cdr.detectChanges(); }
    });
  }

  proceedToBuy() {
    this.orderService.createOrder(this.uid).subscribe({
      next: (res: any) => { this.message = `✅ Order placed successfully (Order #${res.orderId})`; this.loadCart(); },
      error: (err) => {
        this.message = (err?.status === 409) ? '❌ Product out of stock' : '❌ Failed to place order';
        this.cdr.detectChanges();
      }
    });
  }

  trackById = (_: number, e: CartEntry) => e.itemId;
}
