import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth-service/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  empId:string;
  prevpass:string;
  newpass:string;
  result:boolean;
  previousPass:string;
  newPassword:string;
  userId:string;

  constructor(private service : AuthService, private route: Router) { }

  ngOnInit() {
  }
  resetPassword(){
    this.service.resetPassword(this.userId, this.previousPass, this.newPassword).subscribe(data =>{
      this.result=data;
      if(this.result == true){
        alert("password successfully changed");
      }else{
        alert("password not changed");
      }
    })
  }

}
