import { Component, OnInit,Input, Output, EventEmitter  } from '@angular/core';
import { Kategorija } from '../models/kategorija.model';
import { KategorijeService } from '../kategorije.service';
import { AuthenticationService } from '../security/authentication.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-kategorije-naviagation-bar',
  templateUrl: './kategorije-naviagation-bar.component.html',
  styleUrls: ['./kategorije-naviagation-bar.component.css']
})
export class KategorijeNaviagationBarComponent implements OnInit {

  naziv:string;



  @Input() 
  kategorije:Kategorija[];
  constructor(private kategorijaService: KategorijeService, private authenticationService: AuthenticationService
    ,private router: Router) { }

  ngOnInit() {
    this.getCategories();
  }
  getProjects(){

  }

  getCategories(){
    this.kategorijaService.getCategories().subscribe((res:Kategorija[])=>{this.kategorije=res});
  }

  logout():void{
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }

  isLoggedIn():boolean{
    return this.authenticationService.isLoggedIn();
  }
  

}
