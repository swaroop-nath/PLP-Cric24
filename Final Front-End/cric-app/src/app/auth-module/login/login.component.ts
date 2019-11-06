import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth-service/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  id : string;
  password : string;
  result : string;

  constructor(private service:AuthService, private route:Router) { }

  ngOnInit() {
  }

  login(){
    this.service.login(this.id,this.password).subscribe(data=>{
      this.result = data;
      console.log(this.result);
      if(this.result == "admin"||this.result == "blogger"){
        sessionStorage.setItem('type', this.result);
        alert("login successful");
      }else {
        alert("login unsuccessful")
      }
    });
    //this.route.navigate(['getall']);
  }

}
