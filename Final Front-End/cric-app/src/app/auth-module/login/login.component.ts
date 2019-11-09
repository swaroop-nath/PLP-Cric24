import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user.model';
import { AuthService } from '../auth-service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  id : string;
  password : string;
  result : string;
  user : User;

  constructor(private service:AuthService, private route:Router) { }

  ngOnInit() {
  }

  login(){
    this.service.login(this.id,this.password).subscribe(data=>{
      this.user = data;
      console.log(this.user);
      if(this.user == null){
        alert("wrong password")
      }
      else if(this.user.userType == "admin"||this.user.userType == "blogger"){
        sessionStorage.setItem('type', this.user.userType);
        alert("welcome " + this.user.userName);
        this.service.setUserBean(this.user);
        this.route.navigate(['getall'])
      } 
    });
    //this.route.navigate(['getall']);
  }

}
