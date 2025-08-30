import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Productservice } from '../productservice';
import { Router, RouterModule } from '@angular/router';
import { IProduct } from '../iproduct';

@Component({
  selector: 'app-product-list',
  imports: [RouterModule],
  templateUrl: './product-list.html',
  styleUrl: './product-list.css'
})
export class ProductList implements OnInit{
  constructor(private userService:Productservice,private router:Router,private cdr: ChangeDetectorRef) {

   }

  products: IProduct[] = [];


  ngOnInit() {
    console.log("==> productlist Component Initialized");
    this.userService.getProducts().subscribe((data: IProduct[]) => {
      this.products = data;
      console.log('products fetched successfully:', data);
       this.cdr.detectChanges();
    }, (error) => {
      console.error('Error fetching products:', error);
    });

}

  addProduct() {
    this.router.navigate(['/productadd']);
    // Logic to navigate to the user add page
  }

  order() {
    this.router.navigate(['/order']);
    // Logic to navigate to the user order page
  }

  orderHistory() {
    this.router.navigate(['/orderhistory']);
    // Logic to navigate to the user order page
  }
}
