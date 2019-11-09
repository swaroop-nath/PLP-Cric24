import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth-service/auth-service.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  userId:string;
  newPassword:string;
  userFavFood:string;
  userFavAnimal:string;
  result:number;

  constructor(private service : AuthService, private route: Router) { }

  ngOnInit() {
  }
  forgotPassword(){
    this.service.forgotPassword(this.newPassword,this.userId,this.userFavFood,this.userFavAnimal).subscribe(data=>{
      this.result= data;
      if(this.result == 1){
        alert("password changed successfully");
      }else{
        alert("Security questions answered wrong");
      }
    })
  }

}
