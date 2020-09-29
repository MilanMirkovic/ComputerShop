export class AddToCart{
    
    componentId?:number;
    quantity?:number;
    shoppingCartId?:number;

    constructor(adc:AddToCart){
        this.componentId=adc.componentId;
        this.quantity=adc.quantity;
        this.shoppingCartId=adc.shoppingCartId;
    }
}