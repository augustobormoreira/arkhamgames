import { Component, OnInit } from '@angular/core';
import { Game } from '../model/Game';
import { GameService } from './gamescarousel.component.service';
import { DOCUMENT } from '@angular/common';
import { OwlOptions } from 'ngx-owl-carousel-o';

@Component({
  selector: 'app-gamescarousel',
  templateUrl: './gamescarousel.component.html',
  styleUrls: ['./gamescarousel.component.css']
})
export class GamescarouselComponent implements OnInit {

  games: Array<Game> = [];
  gameService: GameService;
  private areaDisplay: any;
  curGameDisplayed: Game = new Game();
  private displayRandom: number = 0;

  constructor(gameService: GameService) {
    this.gameService = gameService;
   }

  ngOnInit(): void {
    this.gameService.getGames().subscribe((data => {
      this.games = data;
      this.displayRandom = Math.floor(Math.random() * this.games.length);
      this.curGameDisplayed = this.games[this.displayRandom];
      this.areaDisplay = document.getElementById('test');
      this.updateCurrentGameDisplayed();
  
    }));
  }

  setDesiredGame(game: Game): void{
    this.curGameDisplayed = game;
    this.updateCurrentGameDisplayed();
  }

  updateCurrentGameDisplayed(){
    this.areaDisplay!.style.backgroundImage = `url(${this.curGameDisplayed.productImageUrl})`;
    this.areaDisplay!.style.backgroundRepeat = 'no-repeat';
    this.areaDisplay!.style.backgroundSize = '100% 100%';
  }

  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: true,
    touchDrag: false,
    pullDrag: false,
    dots: false,
    navSpeed: 700,
    navText: ['', ''],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 2
      },
      740: {
        items: 3
      },
      940: {
        items: 6
      }
    },
    nav: false
  }
}
