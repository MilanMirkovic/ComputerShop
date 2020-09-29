import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'
import { AppComponent } from 'src/app/app.component';
import { PageNotFoundComponent } from 'src/app/page-not-found/page-not-found.component';
import { LoginComponent } from 'src/app/login/login.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { TokenInterceptorService } from 'src/app/security/token-interceptor.service';
import { AuthenticationService } from 'src/app/security/authentication.service';
import { CanActivateAuthGuard } from 'src/app/security/can-activate-auth.guard';
import { JwtUtilsService } from 'src/app/security/jwt-utils.service';
import { PcComponentDetailsComponent } from './src/app/pc-component-details/pc-component-details.component';
import { NavigationBarComponent } from './src/app/navigation-bar/navigation-bar.component';
import { ShoppingCartComponent } from './src/app/shopping-cart/shopping-cart.component';
import { GraphicCardsComponent } from './src/app/graphic-cards/graphic-cards.component';
import { ProccesorsComponent } from './src/app/proccesors/proccesors.component';
import { FilterComponent } from './src/app/filter/filter.component';


@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    LoginComponent,
    PcComponentDetailsComponent,
    NavigationBarComponent,
    ShoppingCartComponent,
    GraphicCardsComponent,
    ProccesorsComponent,
    FilterComponent,

    
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
    AuthenticationService,
    CanActivateAuthGuard,
    JwtUtilsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
