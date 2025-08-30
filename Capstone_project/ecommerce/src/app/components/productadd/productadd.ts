import { Component } from '@angular/core';
import { IProduct } from '../../interfaces/iproduct';
import { ProductService } from '../../services/product-service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-productadd',
  imports: [FormsModule],
  templateUrl: './productadd.html',
  styleUrl: './productadd.css'
})
export class Productadd {
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

  constructor(private productService: ProductService, private router: Router) {}

  addProduct() {
    this.productService.addProduct(this.product).subscribe(() => {
      this.router.navigate(['/products']);
    })
}
}
