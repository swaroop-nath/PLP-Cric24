import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private BASE_URL = 'http://localhost:9898/login';
  private ADD_EXT = '/add';
  private LOGIN_EXT = '/enter/';
  private UPD_PWD_EXT = '/updatePassword/';
  private FGT_PWD_EXT = '/forgetPassword/';
  private FETCH_ALL_EXT = '/bloggers';
  private DELETE_EXT = '/delete/';

  constructor(public http:HttpClient) { }

  signup(user : User){
    return this.http.post<User>(this.BASE_URL + this.ADD_EXT, user);
  }

  login(userId : string, userPassword : string):Observable<string>{
    return this.http.get(this.BASE_URL + this.LOGIN_EXT + userId+ "/" + userPassword, {responseType : 'text'});
  }

  resetPassword(userId: string, previousPass: string, newPassword: string): Observable<boolean>{
    return this.http.get<boolean>(this.BASE_URL + this.UPD_PWD_EXT + userId + "/" + previousPass + "/" + newPassword);
  }

  forgotPassword(newPassword: string, userId: string, userFavFood: string, userFavAnimal: string): Observable<boolean>{
    return this.http.put<boolean>(this.BASE_URL + this.FGT_PWD_EXT + newPassword + "/" + userId + "/" + userFavFood + "/" + userFavAnimal, userId);
  }

  getBloggers():Observable<User[]>{
    return this.http.get<User[]>(this.BASE_URL + this.FETCH_ALL_EXT);
  }

  deleteBlogger(userId : string): Observable<boolean>{
    return this.http.delete<boolean>(this.BASE_URL + this.DELETE_EXT + userId);
  }

  isUserLoggedIn():string{
    if(sessionStorage.getItem('type')=="admin")
    return "admin";
    else if(sessionStorage.getItem('type')=="blogger")
    return "blogger";
    return null;
  }

  logOut(){
    sessionStorage.removeItem('type');
  }

}
