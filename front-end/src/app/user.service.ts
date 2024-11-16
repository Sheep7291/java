import { Injectable } from '@angular/core';
import {BehaviorSubject, map, Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {IUser, IUserCredentials} from '../entity/user-model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private user: BehaviorSubject<IUser | null>

  constructor(private http: HttpClient) {
    this.user = new BehaviorSubject<IUser | null>(null);
  }

  getUser(): Observable<IUser | null>{
    return this.user
  }


  signIn(credentials: IUserCredentials): Observable<boolean> {
    const headers: HttpHeaders = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', 'Basic '+ btoa((credentials.username+':'+credentials.password)));

    return this.http
      .get<boolean>('http://localhost:8080/api/users/checkIfUserIsLogged', {headers})

      };
  }
