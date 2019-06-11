import { Component, OnInit, Input } from '@angular/core';
import { ProjekatService } from '../projekat.service';
import { Projekat } from '../models/projekat.model';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  @Input() projekti:Projekat[];
  constructor(private projekatService : ProjekatService) { }

  ngOnInit() {
    this.getRandomProjects();
  }

  getRandomProjects(){
    this.projekatService.getRandomProjects().subscribe((res:Projekat[]) =>{
      this.projekti=res;
    })
  }



}
