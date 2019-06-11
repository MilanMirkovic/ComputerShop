import { Component, OnInit } from '@angular/core';
import { Projekat, ProjekatInterface } from '../models/projekat.model';
import { Kategorija } from '../models/kategorija.model';
import { KategorijeService } from '../kategorije.service';
import { ProjekatService } from '../projekat.service';
import { AuthenticationService } from '../security/authentication.service';
import { KorisnikInterface } from '../models/korisnik.model';

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrls: ['./add-project.component.css']
})

export class AddProjectComponent implements OnInit {

  newProject:Projekat;
  korisnik:KorisnikInterface;
  korisnikUsername:string;
  kategorije:Kategorija[];

  constructor(private kategorijeService:KategorijeService, private projekatService:ProjekatService, private atuhetntication:AuthenticationService) { 
    this.newProject= new Projekat({
      naziv:'',
      opis:'',
      kategorija:{},
      imageUlr:'',
      korisnik:{}
    })
  }

  ngOnInit() {
    this.getCategories();
    this.getUserName();
    this.completeUser();
  }

  getCategories(){
    this.kategorijeService.getCategories().subscribe((res:Kategorija[])=>{
      this.kategorije=res;
    })

  }
  


  getUserName(){
  this.korisnikUsername= this.atuhetntication.getUser();

  }

  completeUser(){
    this.projekatService.getUser(this.korisnikUsername).subscribe((rets:KorisnikInterface)=>{
      this.korisnik=rets;
      this.newProject.korisnik=this.korisnik;
    })
  }

  saveProject(){
    let p=this.newProject;
    this.projekatService.saveProject(p).subscribe((res:Projekat)=>{
      this.newProject;
    });
  }

}
