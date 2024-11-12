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


  signIn(credentials: IUserCredentials): Observable<IUser> {
    const headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',});
    return this.http
      .post<IUser>('http://localhost:8080/authenticate', credentials, {
        withCredentials: true,
      })
      .pipe(map((user: IUser) => {
        this.user.next(user);
        return user;

      }));
  }}
