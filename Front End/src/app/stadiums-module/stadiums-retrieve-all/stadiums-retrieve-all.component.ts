import { Component, OnInit } from '@angular/core';
import { Stadium } from 'src/app/model/stadium.model';
import { StadiumsService } from '../stadiums-service/stadiums-service.service';
import * as $ from 'jquery';

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
    this.onStart()

    $(window).on('popstate', function(event) {
      $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
      $('#archives-outlet').animate({height: '100%', width: '25%'}, 500).show()
      $('#blogs-outlet').animate({height: '100%', width: '70%'}).show()
      $('#stadiums-outlet').animate({height: '0px', width: '0px'}).hide()
    });
  }

  onStart() {
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#teams-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#players-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#stadiums-outlet').animate({height: '100%', width: '100%'}).show()
  }

}
