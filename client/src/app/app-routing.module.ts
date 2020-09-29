import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanActivateAuthGuard } from './security/can-activate-auth.guard';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

import { PcComponentDetailsComponent } from './pc-component-details/pc-component-details.component';

import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { GraphicCardsComponent } from './graphic-cards/graphic-cards.component';
import { ProccesorsComponent } from './proccesors/proccesors.component';
import { AppComponent } from './app.component';
import { FilterComponent } from './filter/filter.component';

const routes: Routes = [
{path:'main', component:PcComponentDetailsComponent},
{path:'shoppingCart', component:ShoppingCartComponent},
{path:'graphicsCards', component:GraphicCardsComponent},
{path:'proccesors', component:ProccesorsComponent},
{path:'filter/:id/:name', component:FilterComponent},
   { path: 'login', component: LoginComponent},
   {path:'reload', component:AppComponent},
 { path: '', redirectTo: 'main', pathMatch: 'full' },
 { path: 'login', component: LoginComponent}, 
  // { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
