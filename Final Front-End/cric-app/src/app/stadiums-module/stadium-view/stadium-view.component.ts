import { Component, OnInit } from '@angular/core';
import { StadiumsService } from '../stadiums-service/stadiums-service.service';
import { Stadium } from 'src/app/model/stadium.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stadium-view',
  templateUrl: './stadium-view.component.html',
  styleUrls: ['./stadium-view.component.css']
})
export class StadiumViewComponent implements OnInit {

  private receivedStadium: Stadium;

  constructor(private service: StadiumsService, private router: Router) { }

  ngOnInit() {
    this.receivedStadium = this.service.transitStadium;
  }

  update() {
    this.service.transitStadium = this.receivedStadium;
    this.router.navigate([{outlets: {'stadiums': ['update-stadium']}}], {relativeTo: this.service.getParentRoute()})
  }

  delete(stadium: Stadium) {
    this.service.deleteStadium(stadium.stadiumId);
  }

}
