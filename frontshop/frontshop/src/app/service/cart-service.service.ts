import { Injectable } from '@angular/core';
import { NG_ASYNC_VALIDATORS } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { Game } from '../components/model/Game';

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {


  public myCart: any = [];
  public productList = new BehaviorSubject<any>([]);
  constructor() { }

  getProductList(){
    return this.productList.asObservable();
  }

  setProduct(product: any){
    this.myCart.push(...product);
    this.productList.next(product);
  }

  addToCart(product: any){
    this.myCart.push(product);
    this.productList.next(this.myCart);
    this.getTotalPrice();
    console.log(this.myCart);
  }

  getTotalPrice(){
    let totalAmmount = 0;
    this.myCart.map((cartItem: any)=> {
      totalAmmount +=cartItem.productPrice;
    })

    return totalAmmount;
  }

  removeCartItem(product: Game){
    this.myCart.map((cartItem: any, index:any)=> {
      if(product.productName.localeCompare(cartItem.productName) == 0){
        this.myCart.splice(index, 1);
      }
    })
    this.productList.next(this.myCart);
  }

  removeAllItems(){
    this.myCart = [];
    this.productList.next(this.myCart);
  }


}
