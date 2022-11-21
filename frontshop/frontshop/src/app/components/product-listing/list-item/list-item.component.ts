import { Component, Input, OnInit } from '@angular/core';
import { Game } from 'src/app/components/model/Game';
import { CartServiceService } from 'src/app/service/cart-service.service';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.css']
})
export class ListItemComponent implements OnInit {


  @Input()
  game!: Game;
  constructor(private cartService: CartServiceService) { }

  ngOnInit(): void {
  }


  addItemToCart(gameToBeAdded: any){
    this.cartService.addToCart(gameToBeAdded);
  }
}
