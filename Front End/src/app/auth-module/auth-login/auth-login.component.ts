import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { AuthService } from '../auth-service/auth-service.service';

@Component({
  selector: 'app-auth-login',
  templateUrl: './auth-login.component.html',
  styleUrls: ['./auth-login.component.css']
})
export class AuthLoginComponent implements OnInit {
  id : string;
  password : string;
  result : string;

  constructor(private authService:AuthService) { }

  ngOnInit() {
    $(window).on('popstate', function(event) {
      // $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
      $('#auth-outlet').animate({height: '0%', width: '0%'}, 500).hide();
      // $('#blogs-outlet').animate({height: '100%', width: '70%'}).show()
    });

    // $("input").focus(function(){
    //   //we add the css class blur to the elements that we would like to blur on focus
    //       $('#schedules-outlet').blur;
    //       $('#blogs-outlet').blur;
    //   }).blur(function(){
    //   //we remove the blur class which will remove the blur from the elements specified when we are no longer focused on an input
    //       $('#auth-outlet').removeClass("blur");
    //       // $("p").removeClass("blur");
    //   });

    this.onStart();
    
    // // Check if receivedMatch is empty, if empty - go back.
    // this.wonBy = this.receivedMatch.winningTeam.teamName + ' won the match by ' + Math.abs(this.receivedMatch.matchScoreCard.teamOneScore - this.receivedMatch.matchScoreCard.teamTwoScore) + ' runs.'
  }
  onStart() {
    $('#auth-outlet').animate({height: '75%', width: '75%'}, 500).show();
    $('#blogs-outlet').animate({height: '100%', width: '70%'}).blur();
    // $('#auth-outlet').focus(function(){$('#schedules-outlet').addClass("blur");
    //       $('#blogs-outlet').addClass("blur")}).blur;
    
  }

  login(){
    this.authService.login(this.id,this.password).subscribe(data=>{
      this.result = data;
      console.log(this.result);
      if(this.result == "admin"){
        sessionStorage.setItem('type', this.result);
        alert("Login successful as an Admin!");
      }else if(this.result == "blogger") {
        alert("Login successful as Blogger!")
      }
      else{
        alert("Login unsuccessful! Enter valid credentials!")
      }
    });
  }

}
