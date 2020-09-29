import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CategoryInterface } from '../model/Category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }


getAllCategories():Observable<CategoryInterface[]>{
  return this.http.get<CategoryInterface[]>(`api/categories`);
}
}
