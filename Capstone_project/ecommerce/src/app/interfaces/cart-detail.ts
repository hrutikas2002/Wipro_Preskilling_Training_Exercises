import { CartItemDetail } from "./cart-item-detail";

export interface CartDetail {
    id?: number;
  userId: number;
  items: CartItemDetail[];
  totalQty: number;
  subtotal: number;
}
