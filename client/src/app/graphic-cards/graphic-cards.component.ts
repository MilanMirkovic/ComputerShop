import { Component, OnInit } from '@angular/core';
import { PcComponentService } from '../services/pc-component.service';
import { PcComponentInterface } from '../model/PcComponent.model';
import { CartiItemServiceService } from '../services/carti-item-service.service';
import { AuthenticationService } from '../security/authentication.service';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import { SecurityUserInterface } from '../model/SecurityUser.model';
import { ShoppingCartInterface } from '../model/ShoppingCart.model';
import { AddToCart } from '../model/AddToCart.model';

@Component({
  selector: 'app-graphic-cards',
  templateUrl: './graphic-cards.component.html',
  styleUrls: ['./graphic-cards.component.css']
})
export class GraphicCardsComponent implements OnInit {

  username:string;


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
    this.pcComponentService.getComponentsByCategoryId(1).subscribe((res:Page)=>{
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
