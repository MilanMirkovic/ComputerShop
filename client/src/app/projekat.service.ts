import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Projekat } from './models/projekat.model';
import { Donacija } from './models/donacija.model';
import { Faq } from './models/faq.model';
import { KorisnikInterface } from './models/korisnik.model';

@Injectable({
  providedIn: 'root'
})
export class ProjekatService {

  constructor(private http: HttpClient) { }


  
  findByNameContais(naziv: string): Observable<Projekat[]>{
    return this.http.get<Projekat[]>(`/api/projekat/${naziv}`);
  }

  getProject(id: number): Observable<Projekat>{
     return this.http.get<Projekat>(`/api/projekti/${id}`);
  }

  getRandomProjects(): Observable<Projekat[]>{
    return this.http.get<Projekat[]>('/api/projekti/random');
  }
  
  getDonacije(projectId:number): Observable<Donacija[]>{
    return this.http.get<Donacija[]>(`/api/donacije/${projectId}`);
  }

  saveDonacija(donacija:Donacija): Observable<Donacija>{
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Donacija>("/api/donacije", JSON.stringify(donacija), {headers});
    console.log("serviceee");
  }

  getFaqs(id:number):Observable<Faq[]>{
    return this.http.get<Faq[]>(`/api/projekti/${id}/faq`);
  }

  getUser(user:string): Observable<KorisnikInterface>{
    return this.http.get<KorisnikInterface>(`/api/user/${user}`);
  }
 
  saveProject(projekat:Projekat):Observable<Projekat>{
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Projekat>('api/projekti/',JSON.stringify(projekat),{headers});
  }
}
