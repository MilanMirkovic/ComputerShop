import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanActivateAuthGuard } from './security/can-activate-auth.guard';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { KategorijeNaviagationBarComponent } from './kategorije-naviagation-bar/kategorije-naviagation-bar.component';
import { KategorijaStranicaComponent } from './kategorija-stranica/kategorija-stranica.component';

const routes: Routes = [
   { path: 'kategorija/:id', component:KategorijaStranicaComponent },
   { path: 'main', component: KategorijeNaviagationBarComponent},  
  // { path: 'login, component: LoginComponent},  
  // { path: '', redirectTo: 'main', pathMatch: 'full' },
  // { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
