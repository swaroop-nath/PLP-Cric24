import { Component, OnInit } from '@angular/core';
import { User } from '../login-model/user.model';
import { AuthService } from '../auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user : User; 
  
  constructor(private service : AuthService, private route : Router) {
    this.user= new User();
   }

  ngOnInit() {
  }

  signup(){
    this.service.signup(this.user).subscribe(data => this.user = data);
    console.log(this.user);
    this.user = new User();
    this.route.navigate(['login']);
  }

}
