import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team.model';
import { TeamsService } from '../teams-service/teams-service.service';
import * as $ from 'jquery';

@Component({
  selector: 'app-team-view',
  templateUrl: './team-view.component.html',
  styleUrls: ['./team-view.component.css']
})
export class TeamViewComponent implements OnInit {

  receivedTeam: Team;
  wins = 5;
  losses = 1;
  draws = 0;

  constructor(private service: TeamsService) { }

  ngOnInit() {
    this.receivedTeam = this.service.transitTeam;
    console.log(this.receivedTeam);
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#schedules-outlet-child').hide()
    $('#blogs-outlet-child').hide()
    $('#teams-outlet').show().animate({height: '100%', width: '100%'}).click(function(){
      alert('Hello')
    })
    $('#teams-outlet-child').show()
  }

  // write a logic to fetch matches of the team to display total losses and total wins

}
