import { BrandInterface } from './Brand.motel';
import { CategoryInterface } from './Category.model';

export interface PcComponentInterface {

    id?:number;
    name?:string;
    price?:number;
    category?:CategoryInterface;
    brand?:BrandInterface;
}

export class PcComponent implements PcComponentInterface{

    id:number;
    name:string;
    price:number;
    category:CategoryInterface;
    brand:BrandInterface;

    constructor(component:PcComponentInterface){
        this.id=component.id;
        this.name=component.name;
        this.price=component.price;
        this.category=component.category;
        this.brand=component.brand;
    }
}