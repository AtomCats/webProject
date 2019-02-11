import { Component, OnInit } from '@angular/core';
import {EcommerceService} from "../services/EcommerceService";
import {Subscription} from "rxjs/index";
import {Product} from "../models/product.model";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products: Product[] = [];
  sub: Subscription;
  productSelected: boolean = false;

  constructor(private ecommerceService: EcommerceService) {}

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts() {
    this.ecommerceService.getAllProducts()
      .subscribe(
        (products: any[]) => {
          this.products = products;
        },
        (error) => console.log(error)
      );
  }
}
