export class Product {
  id : number;
  name : string;
  category : string;
  pictureUrl : string;
  url : string;

  constructor(id : number, name : string, category : string, pictureUrl : string, url : string) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.pictureUrl = pictureUrl;
    this.url = url;
  }
}
