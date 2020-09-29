import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject, BehaviorSubject } from 'rxjs';
import { CartItem, CartItemInterface } from '../model/CartItem.model';
import { AddToCart } from '../model/AddToCart.model';
import { ShoppingCartInterface } from '../model/ShoppingCart.model';

@Injectable({
  providedIn: 'root'
})
export class CartiItemServiceService {

  constructor(private http:HttpClient) { }


  getCartItemsOfUser(id:number):Observable<CartItem[]>{
    return this.http.get<CartItem[]>(`api/cartItem/user/${id}`);
  }

  addToCart(component:AddToCart):Observable<AddToCart>{
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<AddToCart>(`api/addToCart`,JSON.stringify(component),{headers});
  }
  getShoppingCartByUsername(username:string):Observable<ShoppingCartInterface>{
    return this.http.get<ShoppingCartInterface>(`api/shoppingCart/${username}`);
  }
  updateCartItem(id:number, item:AddToCart):Observable<CartItemInterface>{
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.put<CartItemInterface>(`api/addToCart/${id}`,item,{headers});
  }
  deleteCartItem(id:number):Observable<CartItemInterface>{
    return this.http.delete<CartItemInterface>(`api/deleteCartItem/${id}`);
  }
  private sendItem=new BehaviorSubject<any>(AddToCart);
  cartItem=this.sendItem.asObservable();

  private sentCartItemsLength=new BehaviorSubject<any>(Number);

  cartItemLength=this.sentCartItemsLength.asObservable();

  sendCartLength(number:number){
    this.sentCartItemsLength.next(number);
  }


  sendItemToShoppingCart(item:AddToCart){
    this.sendItem.next(item);
  }
}
