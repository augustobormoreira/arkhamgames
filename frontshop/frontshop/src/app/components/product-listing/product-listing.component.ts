import { Component, OnInit } from '@angular/core';
import { Game } from '../model/Game';
import { GameService } from './product-listing.component.service';

@Component({
  selector: 'app-product-listing',
  templateUrl: './product-listing.component.html',
  styleUrls: ['./product-listing.component.css']
})
export class ProductListingComponent implements OnInit {
  nameToSearch: String;
  
  games: Array<Game> = [];
  gameService: GameService;
  constructor(gameService: GameService) {
    this.gameService = gameService;
    this.nameToSearch = "";
  }  
 
  ngOnInit(): void {
    this.retrieveAllGames();
  }

  retrieveNamedGame(gameToBeSearched: HTMLInputElement){
    let tempArrayOfGames: Array<Game> = []
      for(let game of this.games){
        if(game.productName.toLocaleLowerCase().indexOf(gameToBeSearched.value.toLocaleLowerCase()) >= 0){
          tempArrayOfGames.push(game);
        }
      }

      this.games = tempArrayOfGames;
  }

  returnAllGames(gameToBeSearched: HTMLInputElement){
    if(gameToBeSearched.value.toLocaleLowerCase() == ""){
      this.retrieveAllGames();
    }
  }

  retrieveAllGames(){
    this.gameService.getGames().subscribe((data => {
      this.games = data;
    }));
  }

}
