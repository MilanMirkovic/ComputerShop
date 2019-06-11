import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanActivateAuthGuard } from './security/can-activate-auth.guard';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { KategorijeNaviagationBarComponent } from './kategorije-naviagation-bar/kategorije-naviagation-bar.component';
import { KategorijaStranicaComponent } from './kategorija-stranica/kategorija-stranica.component';
import { ProjekatDetailsComponent } from './projekat-details/projekat-details.component';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { FilterProjekatComponent } from './filter-projekat/filter-projekat.component';
import { AddProjectComponent } from './add-project/add-project.component';

const routes: Routes = [
  {path: 'projekti/:naziv', component :FilterProjekatComponent},
   { path: 'kategorija/:id', component:KategorijaStranicaComponent },
   {path: 'projekat/:id', component:ProjekatDetailsComponent},
    { path: 'main', component: MainComponent},  
    {path: 'addproject' ,component:AddProjectComponent,  canActivate:[CanActivateAuthGuard]},
 
   { path: 'login', component: LoginComponent},
 { path: '', redirectTo: 'main', pathMatch: 'full' },
  // { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
