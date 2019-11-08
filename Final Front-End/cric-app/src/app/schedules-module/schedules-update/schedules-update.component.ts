import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { Router } from '@angular/router';
import { MatchFormat } from 'src/app/model/match-format.enum';
import { MatchStatus } from 'src/app/model/match-status.enum';
import { SchedulesService } from '../schedules-service/schedules-service.service';
import { Team } from 'src/app/model/team.model';
import { Stadium } from 'src/app/model/stadium.model';
import { TeamsService } from 'src/app/teams-module/teams-service/teams-service.service';
import { StadiumsService } from 'src/app/stadiums-module/stadiums-service/stadiums-service.service';

@Component({
  selector: 'app-schedules-update',
  templateUrl: './schedules-update.component.html',
  styleUrls: ['./schedules-update.component.css']
})
export class SchedulesUpdateComponent implements OnInit {
  match: Match;
  updatedMatch: Match;
  matchFormats: string[] = [];
  matchStatuses: string[] = [];
  teams:Team[]=[];
  stadiums:Stadium[]=[];
  teamOneIndex: number;
  teamTwoIndex: number;
  stadiumIndex:number;
  constructor(private service: SchedulesService, private route:Router, private teamService:TeamsService, private stadiumService:StadiumsService) { 
    this.match = new Match();
    this.teams = [];
  }

  ngOnInit() {
    this.match = this.service.transitSchedule;
    console.log(this.match)

    this.matchFormats[0] = MatchFormat.T20;
    this.matchFormats[1] = MatchFormat.ODI;
    this.matchFormats[2] = MatchFormat.TEST;

    this.matchStatuses[0] = MatchStatus.SCHEDULED;
    this.matchStatuses[1] = MatchStatus.ONGOING;

    this.teamService.fetchAllTeams().subscribe(teams => this.teams = teams);

    this.stadiumService.listStadium().subscribe(stadiums => this.stadiums=stadiums);

  }

  updateSchedule(){
    this.match.teamOne=this.teams[this.teamOneIndex];
    this.match.teamTwo= this.teams[this.teamTwoIndex];
    this.match.matchVenue= this.stadiums[this.stadiumIndex];
    this.service.updateMatch(this.match).subscribe(data => {
      //do something to go back
    });
  }


}
