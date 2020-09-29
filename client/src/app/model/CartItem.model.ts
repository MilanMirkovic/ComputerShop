import { PcComponentInterface } from './PcComponent.model';
import { ShoppingCartInterface } from './ShoppingCart.model';

export interface CartItemInterface{
    id?:number;
    quantity?:number;
    component?:PcComponentInterface;
    shoppingCart?:ShoppingCartInterface;
    shoppingCartId?:number;
}

export class CartItem{
    id:number;
    quantity:number;
    component:PcComponentInterface;
    shoppingCart:ShoppingCartInterface;
    shoppingCartId:number;
    constructor(cartItem:CartItemInterface){
        this.id=cartItem.id;
        this.quantity=cartItem.quantity;
        this.component=cartItem.component;
        this.shoppingCart=cartItem.shoppingCart;
        this.shoppingCartId=cartItem.shoppingCartId;
    }

}

