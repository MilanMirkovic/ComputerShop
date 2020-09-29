import { Component, OnInit } from '@angular/core';
import { CartiItemServiceService } from '../services/carti-item-service.service';
import { AuthenticationService } from '../security/authentication.service';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import { PcComponentService } from '../services/pc-component.service';
import { SecurityUserInterface } from '../model/SecurityUser.model';
import { CartItemInterface } from '../model/CartItem.model';
import { ShoppingCart, ShoppingCartInterface } from '../model/ShoppingCart.model';
import { AddToCart } from '../model/AddToCart.model';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  username:string;
  user:SecurityUserInterface;
  userId:number;
  cartItems:CartItemInterface[]=[];
  shoppingCart:ShoppingCartInterface;
  cartItem:AddToCart;
  itemToUpdate:AddToCart;
  totalPrice:number;
  constructor(private cartItemService:CartiItemServiceService , private authenticationService: AuthenticationService,private route:Router, private userService:UserServiceService, private pcComponentService:PcComponentService) {
    this.itemToUpdate=new AddToCart({
      quantity:0,
      componentId:0,
      shoppingCartId:0
    })
   }

  ngOnInit() {
    this.cartItemService.cartItem.subscribe(item=>{ if(item =! null){ this.cartItem=item;}else{
      this.cartItem=null;
    }})
    
    console.log(this.authenticationService.getCurrentUser());


    console.log(this.cartItems.length);
    this.getCurrentUsername();
    this.completeUser();
 
   
     
  }

  checkQuantity(quantity:number){
    if(quantity==1){
      return false;
    }else{
      return true;
    }
  }

  totaPriceFunction(){
    let sum=0;
    for(let c of this.cartItems){
      sum +=c.quantity*c.component.price;
    
     
    }
    this.totalPrice=sum;
    
  }
  updateCart(id:number,addOrRemove:string,item:CartItemInterface){
    if(addOrRemove==="remove"){
     
      
      this.itemToUpdate.shoppingCartId=item.shoppingCart.id;
      this.itemToUpdate.componentId=item.component.id;
      this.itemToUpdate.quantity=item.quantity-1;
      this.cartItemService.updateCartItem(id,this.itemToUpdate).subscribe((res:AddToCart)=>{
        window.location.reload();
      })
    }else{
      
      this.itemToUpdate.shoppingCartId=item.shoppingCart.id;
      this.itemToUpdate.componentId=item.component.id;
      this.itemToUpdate.quantity=item.quantity+1;
      this.cartItemService.updateCartItem(id,this.itemToUpdate).subscribe((res:AddToCart)=>{
        window.location.reload();
    })
  }
}
  getCurrentUsername(){
    this.username= this.authenticationService.getUser();
    console.log(this.username);
 
 
    }
    deleteCartItem(id:number){
      this.cartItemService.deleteCartItem(id).subscribe((res:CartItemInterface)=>{
        window.location.reload();
      })
    }
  
    completeUser(){
      this.userService.getUser(this.username).subscribe((res:SecurityUserInterface)=>{
        this.user=res;
        this.userId=this.user.id;
       this.getCartItemOfUser(this.userId);
      })
    }
  
    getCartItemOfUser(id:number){
   
      this.cartItemService.getCartItemsOfUser(id).subscribe((res:CartItemInterface[])=>{
       
        this.cartItems=res;
 
        this.totaPriceFunction();

      this.sendCartItemLength(res.length);
      console.log(res.length);
        
      })
     
    }
    getShoppingCartByUserName(){
      this.cartItemService.getShoppingCartByUsername(this.username).subscribe((res:ShoppingCartInterface)=>{
        this.shoppingCart=res;
      })
    }

    addToCartItem(item:AddToCart){
      this.cartItemService.addToCart(item).subscribe((res:AddToCart)=>{
        window.location.reload();
    })}

    sendCartItemLength(len:number){
      this.cartItemService.sendCartLength(len);
   
    }
}
