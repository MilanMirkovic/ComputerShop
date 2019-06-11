import { Component, OnInit } from '@angular/core';
import { Projekat } from '../models/projekat.model';
import { ProjekatService } from '../projekat.service';
import { ActivatedRoute } from '@angular/router';
import { Donacija } from '../models/donacija.model';
import { Faq } from '../models/faq.model';
import { AuthenticationService } from '../security/authentication.service';



@Component({
  selector: 'app-projekat-details',
  templateUrl: './projekat-details.component.html',
  styleUrls: ['./projekat-details.component.css']
})
export class ProjekatDetailsComponent implements OnInit {

  donacija: Donacija[];
  id: number;
 
  private sub: any;

  newDonacija:Donacija;

  faqs:Faq[];
  projekat: Projekat;
  novaDonacija:number;
  
  suma: number =0;
  brojDonacija:number;
  zeljenaSuma:number;

  constructor(private projekatService: ProjekatService, private route: ActivatedRoute, private authenticationService:AuthenticationService) { 
    this.newDonacija = new Donacija({
      iznos:0,
     projekat:{}
    })
  }

  ngOnInit() {
    this.getDonacije();
    this.getProject();
   this.getFaqs();
   
  }


  getProject() {
    
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.projekatService.getProject(this.id).subscribe((res: Projekat) => {
        this.projekat = res;
        
      })
    });

  }

  getDonacije() {
  
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.projekatService.getDonacije(this.id).subscribe((res: Donacija[]) => {
        this.donacija = res;
       this.zeljenaSuma=this.donacija[0].zeljeniIznos;
       this.total();
       
       this.brojDonacija=this.donacija.length;
       this.newDonacija.projekat=this.projekat;
      })
    });

  }
  getFaqs(){
    this.sub=this.route.params.subscribe(params=>{
      this.id=+params['id'];
      this.projekatService.getFaqs(this.id).subscribe((res:Faq[])=>{
        this.faqs=res;
      });
    });
  }

  total(){
   
    let s=0;
    for(let d of this.donacija){
      s+=d.iznos;
    }
    this.suma=s;

  }

  doniraj(){
    
    let a= this.suma+this.newDonacija.iznos;
  
    
    this.brojDonacija++;
    this.suma=a;

    this.saveDonacija();
  }



saveDonacija(){
  let d=this.newDonacija;
  this.projekatService.saveDonacija(d).subscribe((res:Donacija) =>{
  this.getDonacije();
})

}

isLoggedIn():boolean{
  return this.authenticationService.isLoggedIn();
}


}
