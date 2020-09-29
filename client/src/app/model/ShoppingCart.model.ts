import { CartItemInterface } from './CartItem.model';
import { SecurityUserInterface } from './SecurityUser.model';

export interface ShoppingCartInterface{
    id?:number;
    user?:SecurityUserInterface;
    cartItems?:CartItemInterface[];
}

export class ShoppingCart{
    id:number;
    user:SecurityUserInterface;
    cartItems:CartItemInterface[];

    constructor(cart:ShoppingCartInterface){
        this.id=cart.id;
        this.user=cart.user;
        this.cartItems=cart.cartItems;
    }
}
