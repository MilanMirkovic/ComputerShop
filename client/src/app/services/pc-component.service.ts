import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PcComponent } from '../model/PcComponent.model';

@Injectable({
  providedIn: 'root'
})
export class PcComponentService {

  constructor(private http:HttpClient) { }

  getAllComponents():Observable<Page>{
    return this.http.get<Page>(`api/components`);
  }
  getComponentById(id:number):Observable<PcComponent>{
    return this.http.get<PcComponent>(`api/components/${id}`)
  }
  filterComponentByName(name:string):Observable<Page>{
    return this.http.get<Page>(`api/components/filter?name=${name}`)
  }

  getComponentsByCategoryId(id:number):Observable<Page>{
    return this.http.get<Page>(`api/components/category/${id}`);
  }

  filterByNameAndCategory(id:number, name:string):Observable<Page>{
    return this.http.get<Page>(`api/components/filter/${id}?name=${name}`);
  }

}
