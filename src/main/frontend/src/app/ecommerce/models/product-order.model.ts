import {Product} from "./product.model";

export class ProductOrder {
  product: Product;
  quantity: number;

  // all arguments constructor

  constructor(product: Product, quantity: number) {
    this.product = product;
    this.quantity = quantity;
  }
}
