import { Component, OnInit } from '@angular/core';
import { SecurityUserInterface } from '../model/SecurityUser.model';
import { ShoppingCartInterface } from '../model/ShoppingCart.model';
import { AddToCart } from '../model/AddToCart.model';
import { CartiItemServiceService } from '../services/carti-item-service.service';
import { AuthenticationService } from '../security/authentication.service';
import { Router } from '@angular/router';
import { PcComponentService } from '../services/pc-component.service';

@Component({
  selector: 'app-proccesors',
  templateUrl: './proccesors.component.html',
  styleUrls: ['./proccesors.component.css']
})
export class ProccesorsComponent implements OnInit {
  username:string;
  user:SecurityUserInterface;
  userId:number;
  shoppingCart:ShoppingCartInterface;
  newItem:AddToCart;
  graphicsCard:Page;
  constructor(private cartItemService:CartiItemServiceService , private authenticationService: AuthenticationService,private route:Router, private pcComponentService:PcComponentService) { 
    this.newItem=new AddToCart({
      componentId:0,
      quantity:0,
      shoppingCartId:0
    })
  }

 
  ngOnInit() {
    this.getGraphics();
    this.getCurrentUsername();
   // this.completeUser();
    this.getShoppingCartByUserName();
  }

  getGraphics(){
    this.pcComponentService.getComponentsByCategoryId(3).subscribe((res:Page)=>{
      this.graphicsCard=res;

    })
  }


    
  isLoggedIn():boolean{
    return this.authenticationService.isLoggedIn();
  }
  
  getCurrentUsername(){
  this.username= this.authenticationService.getUser();
  console.log(this.username);
  }

  addToCartItem(componentId:number){
    this.newItem.quantity=1;
    this.newItem.shoppingCartId=this.shoppingCart.id;
    this.newItem.componentId=componentId;

    this.cartItemService.sendItemToShoppingCart(this.newItem);
    this.cartItemService.addToCart(this.newItem).subscribe((res:AddToCart)=>{
      
    
    })
  }

  getShoppingCartByUserName(){
    this.cartItemService.getShoppingCartByUsername(this.username).subscribe((res:ShoppingCartInterface)=>{
      this.shoppingCart=res;
    })
  }

}
