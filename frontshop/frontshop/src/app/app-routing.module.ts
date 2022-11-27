import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './components/cart/cart.component';
import { LoginComponent } from './components/login/login.component';
import { MainpageComponent } from './components/mainpage/mainpage.component';
import { AuthGuard } from './components/shared/auth/auth.guard';

const routes: Routes = [
  {path: 'mainpage', component: MainpageComponent, canActivate:[AuthGuard]},
  {path: '', redirectTo: 'mainpage', pathMatch: 'full'},
  {path: 'user-login', component: LoginComponent},
  {path: 'cart', component: CartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
