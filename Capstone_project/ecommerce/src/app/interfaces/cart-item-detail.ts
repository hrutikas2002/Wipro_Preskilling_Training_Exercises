import { IProduct } from "./iproduct";

export interface CartItemDetail {
  itemId: number;
  productId: number;
  qty: number;
  product: IProduct | null;
  lineTotal: number;
}
