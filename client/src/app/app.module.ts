import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { AuthenticationService } from './security/authentication.service';
import { CanActivateAuthGuard } from './security/can-activate-auth.guard';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptorService } from './security/token-interceptor.service';
import { JwtUtilsService } from './security/jwt-utils.service';
import { KategorijeNaviagationBarComponent } from './kategorije-naviagation-bar/kategorije-naviagation-bar.component';
import { KategorijaStranicaComponent } from './kategorija-stranica/kategorija-stranica.component';
import { ProjekatDetailsComponent } from './projekat-details/projekat-details.component';
import { MainComponent } from './main/main.component';
import { FilterProjekatComponent } from './filter-projekat/filter-projekat.component';
import { AddProjectComponent } from './add-project/add-project.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    LoginComponent,
    KategorijeNaviagationBarComponent,
    KategorijaStranicaComponent,
    ProjekatDetailsComponent,
    MainComponent,
    FilterProjekatComponent,
    AddProjectComponent
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
