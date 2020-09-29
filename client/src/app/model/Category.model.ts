import { PcComponentInterface } from './PcComponent.model';

export interface CategoryInterface {
    id?:number;
    name?:string;
    cmponents?:PcComponentInterface[];
}

export class Category implements CategoryInterface{
    id:number;
    name:string;
    components:PcComponentInterface[];

    constructor(category:CategoryInterface){
        this.id=category.id;
        this.name=category.name;
        this.components=category.cmponents;
    }
}
