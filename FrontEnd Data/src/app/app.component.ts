import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/auth.service';
import * as $ from 'jquery';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private service:AuthService){}

  ngOnInit(){
    $(document).ready(function(){
      $(".btn").on("click",function(){
        $(".input").toggleClass("inclicked");
        $(".btn").toggleClass("close");
      });
    });
  }
  title = 'login-service';
}
