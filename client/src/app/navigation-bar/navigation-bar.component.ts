import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../security/authentication.service';
import { Router } from '@angular/router';
import { CartiItemServiceService } from '../services/carti-item-service.service';
import { PcComponentService } from '../services/pc-component.service';
import { CategoryInterface } from '../model/Category.model';

import { CategoryService } from '../services/category.service';
import { SecurityUserInterface } from '../model/SecurityUser.model';


@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent implements OnInit {
  cartLength:number;
  id:number;
  categories:CategoryInterface[];
  
  constructor(private categoryService:CategoryService ,private authenticationService: AuthenticationService,private pcService:PcComponentService, private cartItemService:CartiItemServiceService, private router: Router) { }

  ngOnInit() {
    this.cartItemService.cartItemLength.subscribe(number=>{if(number !=null){this.cartLength=number}else{this.cartLength=0}});
    console.log(this.cartLength);
    this.getCategories();
   
  
  }

  
  logout():void{
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }

  isLoggedIn():boolean{
    return this.authenticationService.isLoggedIn();
  }

  getCategories(){
    this.categoryService.getAllCategories().subscribe((res:CategoryInterface[])=>{this.categories=res})
  }
  
  
  isAdmin(){
    
    let user:SecurityUserInterface=this.authenticationService.getCurrentUser();

    if(user.roles[0]==="ROLE_ADMIN"){
      return true;
    }else{
      return false;
    }
  }

}
