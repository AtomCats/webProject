export class Product {
  id : number;
  name : string;
  category : string;
  pictureUrl : string;
  url : string;
  price : number;

  constructor(id : number, name : string, category : string, pictureUrl : string, url : string, price : number) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.pictureUrl = pictureUrl;
    this.url = url;
    this.price = price;
  }
}
