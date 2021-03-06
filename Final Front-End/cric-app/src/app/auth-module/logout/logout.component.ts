import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth-service/auth-service.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private service:AuthService, private route: Router) {
    
  }

  ngOnInit() {
    this.service.loggOut();
    this.route.navigate(['login']);
  }

}
