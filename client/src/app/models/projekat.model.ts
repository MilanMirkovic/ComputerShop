import { Kategorija, KategorijaInterface } from './kategorija.model';
import { KorisnikInterface } from './korisnik.model';

 export interface ProjekatInterface {
    id?:number;
    naziv?:string;
    opis?:string;
    kategorija?:KategorijaInterface;
    imageUlr?:string;
    korisnik?:KorisnikInterface;
    // faq:Faq[];
    // vesti:Vest[];
}



export class Projekat implements ProjekatInterface{
    id: number;    naziv: string;
    opis: string;
    kategorija: KategorijaInterface;
    imageUlr:string;
    korisnik:KorisnikInterface;
    // faq: Faq[];
    // vesti: Vest[];

    constructor(projekat:ProjekatInterface){
        this.id=projekat.id;
        this.opis=projekat.opis;
        this.kategorija=projekat.kategorija;
        this.imageUlr=projekat.imageUlr;
        this.korisnik=projekat.korisnik;
        // this.faq=projekat.faq;
        // this.vesti=projekat.vesti;
    }
}