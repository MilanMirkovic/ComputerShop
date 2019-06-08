import { Component, OnInit } from '@angular/core';
import { Projekat } from '../models/projekat.model';
import { KategorijeService } from '../kategorije.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-kategorija-stranica',
  templateUrl: './kategorija-stranica.component.html',
  styleUrls: ['./kategorija-stranica.component.css']
})
export class KategorijaStranicaComponent implements OnInit {
  id: number;
  private sub:any;

  projekti:Projekat[];

  constructor(private kategorijaService: KategorijeService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getProjects();
  }

  getProjects(){
    this.sub=this.route.params.subscribe(params=>{
      this.id=+params['id'];
    this.kategorijaService.getProjects(this.id).subscribe((res: Projekat[])=>{
      this.projekti=res;
    });
    }
    );
    
  }




  
  

}
