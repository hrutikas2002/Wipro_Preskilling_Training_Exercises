export interface OrderResponse {
  orderId: number;
  status: string; // BE sends "CREATED", etc.
  totalAmount: number;
}
