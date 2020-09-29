import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SecurityUserInterface } from '../model/SecurityUser.model';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http:HttpClient) { }

  getUser(user:string): Observable<SecurityUserInterface>{
    return this.http.get<SecurityUserInterface>(`/api/user/${user}`);
  }
}
