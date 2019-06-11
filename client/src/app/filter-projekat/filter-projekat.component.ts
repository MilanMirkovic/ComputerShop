import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProjekatService } from '../projekat.service';
import { Projekat } from '../models/projekat.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-filter-projekat',
  templateUrl: './filter-projekat.component.html',
  styleUrls: ['./filter-projekat.component.css']
})
export class FilterProjekatComponent implements OnInit {

  constructor(private http:HttpClient, private service:ProjekatService, private route:ActivatedRoute) { }
  
  naziv:string;
  sub: any;

  projekti:Projekat[];

  ngOnInit() {
    this.filterProjects();
  }

  filterProjects(){
    this.sub= this.route.params.subscribe(params => {
      this.naziv=params['naziv'];
      this.service.findByNameContais(this.naziv).subscribe((res:Projekat[])=>{
        console.log("dadada");
        this.projekti=res;
      })
    })
  }



}
