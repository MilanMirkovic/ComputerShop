import { Component, OnInit,Input } from '@angular/core';
import { Kategorija } from '../models/kategorija.model';
import { KategorijeService } from '../kategorije.service';

@Component({
  selector: 'app-kategorije-naviagation-bar',
  templateUrl: './kategorije-naviagation-bar.component.html',
  styleUrls: ['./kategorije-naviagation-bar.component.css']
})
export class KategorijeNaviagationBarComponent implements OnInit {


  @Input() 
  kategorije:Kategorija[];
  constructor(private kategorijaService: KategorijeService) { }

  ngOnInit() {
    this.getCategories();
  }

  getCategories(){
    this.kategorijaService.getCategories().subscribe((res:Kategorija[])=>{this.kategorije=res});
  }


}
