import { PcComponentInterface } from './PcComponent.model';

export interface BrandInterface{
    id?:number;
    name?:string;
    components?:PcComponentInterface[];

}


export class Brand implements BrandInterface{
    id:number;
    name:string;
    components:PcComponentInterface[];

    constructor(b:BrandInterface){
        this.id=b.id;
        this.name=b.name;
        this.components=b.components;
    }
}