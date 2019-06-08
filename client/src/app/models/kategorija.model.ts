import { Projekat } from './projekat.model';

export interface KategorijaInterface{
    id?:number;
    naziv:string;
    projekti:Projekat[];
}


export class Kategorija implements KategorijaInterface{
    id:number;
    naziv:string;
    projekti:Projekat[];

    constructor(kat:KategorijaInterface){
        this.id=kat.id;
        this.naziv=kat.naziv;
        this.projekti=kat.projekti;
    }
}