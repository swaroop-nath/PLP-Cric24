import { Component, OnInit } from '@angular/core';
import { Stadium } from 'src/app/model/stadium.model';
import { StadiumsService } from '../stadiums-service/stadiums-service.service';

@Component({
  selector: 'app-stadiums-retrieve-all',
  templateUrl: './stadiums-retrieve-all.component.html',
  styleUrls: ['./stadiums-retrieve-all.component.css']
})
export class StadiumsRetrieveAllComponent implements OnInit {

  stadiums: Stadium[];

  constructor(private service: StadiumsService) { }

  ngOnInit() {
    this.service.listStadium().subscribe(data => this.stadiums=data);
  }

}
