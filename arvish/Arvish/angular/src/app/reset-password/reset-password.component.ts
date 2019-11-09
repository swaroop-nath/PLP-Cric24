import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { Router } from '@angular/router';
import { User } from '../login-model/user.model';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  empId:string;
  
  result:boolean;
  previousPass:string;
  newPassword:string;
  userId:string;
  user:User;

  constructor(private service : AuthService, private route: Router) {
    this.user = new User();
   }

  ngOnInit() {
    this.user = this.service.getUserBean();
  }
  resetPassword(){
    
    this.service.resetPassword(this.user.userId, this.previousPass, this.newPassword).subscribe(data =>{
      this.result=data;
      if(this.result == true){
        alert("password successfully changed");
      }else{
        alert("Wrong Password! If you dont remember your password , Logout and go to forgot Password");
      }
    })
  }

}
