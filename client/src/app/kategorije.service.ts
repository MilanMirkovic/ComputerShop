import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Kategorija } from './models/kategorija.model';
import { Projekat } from './models/projekat.model';

@Injectable({
  providedIn: 'root'
})
export class KategorijeService {

  constructor(private http:HttpClient) {
  }


  getCategories(): Observable<Kategorija[]>{
    return this.http.get<Kategorija[]>('/api/kategorije');

  }

  getProjects(id:number): Observable<Projekat[]>{
   return  this.http.get<Projekat[]>(`api/kategorije/${id}`);
  }
}
