import {HttpClient} from "@angular/common/http";
import {Subject} from "rxjs/index";
import {Injectable} from "@angular/core";

@Injectable()
export class EcommerceService {
  private _productsUrl = "/api/products";
  private _ordersUrl = "/api/orders";

  private _productOrder: ProductOrder;
  private _orders: ProductOrders = new ProductOrders();

  private _productOrderSubject = new Subject();
  private _ordersSubject = new Subject();
  private _totalSubject = new Subject();

  private _total: number;

  private _ProductOrderChanged = this._productOrderSubject.asObservable();
  private _OrdersChanged = this._ordersSubject.asObservable();
  private _TotalChanged = this._totalSubject.asObservable();

  constructor(private http: HttpClient) {
  }

  getAllProducts() {
    return this.http.get(this._productsUrl);
  }

  saveOrder(order: ProductOrders) {
    return this.http.post(this._ordersUrl, order);
  }

  // getters and setters for shared fields

  set SelectedProductOrder(value: ProductOrder) {
    this.productOrder = value;
    this.productOrderSubject.next();
  }

  get SelectedProductOrder() {
    return this.productOrder;
  }

  set ProductOrders(value: ProductOrders) {
    this.orders = value;
    this.ordersSubject.next();
  }

  get ProductOrders() {
    return this.orders;
  }

  get Total() {
    return this.total;
  }

  set Total(value: number) {
    this.total = value;
    this.totalSubject.next();
  }
}
