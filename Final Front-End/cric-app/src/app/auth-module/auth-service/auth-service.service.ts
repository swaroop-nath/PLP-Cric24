import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

user:User;
  private BASE_URL = 'http://localhost:9898/login';
  private ADD_EXT = '/add';
  private LOGIN_EXT = '/enter/';
  private UPD_PWD_EXT = '/updatePassword/';
  private FGT_PWD_EXT = '/forgetPassword/';
  private FETCH_ALL_EXT = '/bloggers';
  private DELETE_EXT = '/delete/';

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

  isUserLoggedIn():string{
    if(sessionStorage.getItem('type')=="admin")
    return 'admin';
    else if(sessionStorage.getItem('type')=="blogger")
    return 'blogger';
    return null;
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
