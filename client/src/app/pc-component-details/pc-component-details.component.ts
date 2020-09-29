import { Component, OnInit } from '@angular/core';
import { PcComponentService } from '../services/pc-component.service';
import { AuthenticationService } from '../security/authentication.service';
import { SecurityUserInterface } from '../model/SecurityUser.model';
import { UserServiceService } from '../services/user-service.service';
import { CartiItemServiceService } from '../services/carti-item-service.service';
import { CartItemInterface, CartItem } from '../model/CartItem.model';
import { AddToCart } from '../model/AddToCart.model';
import { ShoppingCartInterface } from '../model/ShoppingCart.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pc-component-details',
  templateUrl: './pc-component-details.component.html',
  styleUrls: ['./pc-component-details.component.css']
})
export class PcComponentDetailsComponent implements OnInit {
  components:Page;
  username:string;
  user:SecurityUserInterface;
  userId:number;
  cartItems:CartItemInterface[];
  
  shoppingCart:ShoppingCartInterface;
  newItem:AddToCart;
  constructor(private cartItemService:CartiItemServiceService , private authenticationService: AuthenticationService,private route:Router, private userService:UserServiceService, private pcComponentService:PcComponentService) {
    this.newItem=new AddToCart({
      componentId:0,
      quantity:0,
      shoppingCartId:0
    })
   }

 

  ngOnInit() {
    this.getAllComponents();
    this.getCurrentUsername();
   // this.completeUser();
    this.getShoppingCartByUserName();
   
  }
 

  getAllComponents(){
    this.pcComponentService.getAllComponents().subscribe((res:Page)=>{
      this.components=res;
    })
  }

  
  isLoggedIn():boolean{
    return this.authenticationService.isLoggedIn();
  }
  
  getCurrentUsername(){
  this.username= this.authenticationService.getUser();
  console.log(this.username);
  }

  // completeUser(){
  //   this.userService.getUser(this.username).subscribe((res:SecurityUserInterface)=>{
  //     this.user=res;
  //     this.userId=this.user.id;
  //    this.getCartItemOfUser(this.userId);
  //   })
  // }

  // getCartItemOfUser(id:number){
 
  //   this.cartItemService.getCartItemsOfUser(id).subscribe((res:CartItemInterface[])=>{
     
  //     this.cartItems=res;
      
      
  //   })
   
  // }

  addToCartItem(componentId:number){
    this.newItem.quantity=1;
    this.newItem.shoppingCartId=this.shoppingCart.id;
    this.newItem.componentId=componentId;

    this.cartItemService.sendItemToShoppingCart(this.newItem);
    this.cartItemService.addToCart(this.newItem).subscribe((res:AddToCart)=>{
      this.route.navigate(["/main"]);
    
    })
  }

  getShoppingCartByUserName(){
    this.cartItemService.getShoppingCartByUsername(this.username).subscribe((res:ShoppingCartInterface)=>{
      this.shoppingCart=res;
    })
  }

}
