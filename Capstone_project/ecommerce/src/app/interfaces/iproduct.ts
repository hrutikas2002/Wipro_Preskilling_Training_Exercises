export interface IProduct {
  id?: number;                 // optional for new products
  prodName: string;
  prodDesc: string;
  prodCat: string;             // category: electronics, apparel, etc.
  make: string;
  availableQty: number;
  price: number;
  uom: string;                 // unit of measurement: litre, kg, piece
  prodRating: number;
  imageURL: string;
  dateOfManufacture: string;   // ISO string (YYYY-MM-DD)
}
