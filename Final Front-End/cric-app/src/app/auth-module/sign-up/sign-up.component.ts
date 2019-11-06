import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user.model';
import { AuthService } from '../auth-service/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

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
