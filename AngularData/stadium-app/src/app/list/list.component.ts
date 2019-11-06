import { Component, OnInit } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { StadiumdetailsService } from '../services/stadiumdetails.service';
import { t, st } from '@angular/core/src/render3';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  stadiums: StadiumModel[];

  constructor(private service: StadiumdetailsService) { }

  ngOnInit() {
    this.service.listStadium().subscribe(data => this.stadiums=data);
  }

}
