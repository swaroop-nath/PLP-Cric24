import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { ActivatedRoute, Router } from '@angular/router';
import { CricketService } from './cricket-service/cricket-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  title = 'cric-app';

  constructor(private route: ActivatedRoute, private cricService: CricketService, private router:Router) {
    cricService.parentRoute = route;
  }

  ngOnInit(): void {
  }

  loginPopUp(){
    this.router.navigate([{outlets: {'auth':'auth-login'}}]);
    $(window).blur();
  }

  
}
