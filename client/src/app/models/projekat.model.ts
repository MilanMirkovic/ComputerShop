import { Kategorija } from './kategorija.model';

export interface ProjekatInterface {
    id?:number;
    naziv:string;
    opis:string;
    kategorija:Kategorija;
    imageUlr:string;
    // faq:Faq[];
    // vesti:Vest[];
}



export class Projekat implements ProjekatInterface{
    id?: number;    naziv: string;
    opis: string;
    kategorija: Kategorija;
    imageUlr:string;
    // faq: Faq[];
    // vesti: Vest[];

    constructor(projekat:ProjekatInterface){
        this.id=projekat.id;
        this.opis=projekat.opis;
        this.kategorija=projekat.kategorija;
        this.imageUlr=projekat.imageUlr;
        // this.faq=projekat.faq;
        // this.vesti=projekat.vesti;
    }
}