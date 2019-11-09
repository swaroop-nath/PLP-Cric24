import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../login-model/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user:User;

  constructor(public http:HttpClient) { 
    this.user = new User();
  }

  signup(user : User){
    return this.http.post<User>("http://localhost:9898/login/add", user);
  }

  login(userId : string, userPassword : string):Observable<User>{
    return this.http.get<User>("http://localhost:9898/login/enter/"+userId+"/"+userPassword);
  }

  resetPassword(userId: string, previousPass: string, newPassword: string){
    return this.http.get<boolean>("http://localhost:9898/login/updatePassword/"+userId+"/"+previousPass+"/"+newPassword);
  }

  forgotPassword(newPassword: string, userId: string, userFavFood: string, userFavAnimal: string){
    return this.http.put<number>("http://localhost:9898/login/forgetPassword/"+newPassword+"/"+userId+"/"+userFavFood+"/"+userFavAnimal, userId);
  }

  getBloggers():Observable<User[]>{
    return this.http.get<User[]>("http://localhost:9898/login/bloggers");
  }

  isUserLoggedIn():number{
    if(sessionStorage.getItem('type')=="admin")
    return 1;
    else if(sessionStorage.getItem('type')=="blogger")
    return 2;
    return 0;
  }

  loggOut(){
    sessionStorage.removeItem('type');
  }

  deleteBlogger(userId : string){
    return this.http.delete<boolean>("http://localhost:9898/login/admin/delete/"+userId).subscribe();
  }

  setUserBean(user:User){
    this.user = user;
  }

  getUserBean(){
    return this.user;
  }
}
