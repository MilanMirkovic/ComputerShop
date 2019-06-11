import { Projekat, ProjekatInterface} from './projekat.model';

 interface DonacijaInterface{
    iznos?:number;
    zeljeniIznos?:number;
    projekat?:ProjekatInterface;
    
}

export class Donacija  implements DonacijaInterface{
    iznos: number;  
    projekat: ProjekatInterface;
    zeljeniIznos:number;
    constructor(d:DonacijaInterface){
        this.zeljeniIznos=d.zeljeniIznos;
        this.iznos=d.iznos;
        this.projekat=d.projekat;
    }

    
}

