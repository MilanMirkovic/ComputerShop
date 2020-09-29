import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { PcComponentService } from '../services/pc-component.service';
import { AddToCart } from '../model/AddToCart.model';
import { CartiItemServiceService } from '../services/carti-item-service.service';
import { ShoppingCartInterface } from '../model/ShoppingCart.model';
import { AuthenticationService } from '../security/authentication.service';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  components:Page;
  sub:any;
  id:number;
  name:string;
  newItem:AddToCart;
  shoppingCart:ShoppingCartInterface;
  username:string;

  constructor(private route: ActivatedRoute,private http:HttpClient,private componentService:PcComponentService,private cartItemService:CartiItemServiceService,private authenticationService: AuthenticationService ) {
    this.newItem=new AddToCart({
      componentId:0,
      quantity:0,
      shoppingCartId:0
    })
  }

   

  ngOnInit() {
    this.filterComponents();
    this.getCurrentUsername();
 
     this.getShoppingCartByUserName();
  }

  filterComponents(){
    this.sub=this.route.params.subscribe(params=>{
      this.id=+params['id'];
      this.name=params['name'];
      this.componentService.filterByNameAndCategory(this.id,this.name).subscribe((res:Page)=>{
        this.components=res;
      })
    })
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

    
  getCurrentUsername(){
    this.username= this.authenticationService.getUser();
    console.log(this.username);
    }
}
