import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { Router } from '@angular/router';

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
