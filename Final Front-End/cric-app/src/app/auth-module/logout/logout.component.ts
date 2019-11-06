import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth-service/auth-service.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private service:AuthService) { }

  ngOnInit() {
    this.service.loggOut();
  }

}
