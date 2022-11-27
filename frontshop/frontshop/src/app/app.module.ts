import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './components/shared/nav/nav.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { MainpageComponent } from './components/mainpage/mainpage.component';
import { GamescarouselComponent } from './components/gamescarousel/gamescarousel.component';
import { GameService } from './components/gamescarousel/gamescarousel.component.service';
import { HttpClientModule } from '@angular/common/http';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { OptionsBarComponent } from './components/shared/options-bar/options-bar.component';
import { LoginComponent } from './components/login/login.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AddproductComponent } from './components/addproduct/addproduct.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductListingComponent } from './components/product-listing/product-listing.component';
import { ListItemComponent } from './components/product-listing/list-item/list-item.component';
import { CartComponent } from './components/cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    MainpageComponent,
    GamescarouselComponent,
    OptionsBarComponent,
    LoginComponent,
    AddproductComponent,
    ProductListingComponent,
    ListItemComponent,
    CartComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MatIconModule,
    CarouselModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule
  ],
  providers: [GameService],
  bootstrap: [AppComponent]
})
export class AppModule { }
