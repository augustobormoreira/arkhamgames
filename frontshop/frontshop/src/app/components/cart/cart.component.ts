import { Component, OnInit } from '@angular/core';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { CartServiceService } from 'src/app/service/cart-service.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  faTrash = faTrash;

  purchaseEnded: boolean = false;

  public productList: any = [];
  public totalPrice: number = 0;
  constructor(private cartService: CartServiceService) { }

  ngOnInit(): void {
    this.purchaseEnded = false;
    this.cartService.getProductList()
    .subscribe(res => {
      this.productList = res;
      this.totalPrice = this.cartService.getTotalPrice();
    })
  }

  removeItem(product: any){
    this.cartService.removeCartItem(product)
  }

  removeAllItems(){
    this.cartService.removeAllItems();
  }

  finalizePurchase(){
    this.purchaseEnded = true;
    this.removeAllItems();
  }

}
