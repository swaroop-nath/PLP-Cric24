import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { MatchFormat } from 'src/app/model/match-format.enum';
import { Team } from 'src/app/model/team.model';
import { Stadium } from 'src/app/model/stadium.model';
import { SchedulesService } from '../schedules-service/schedules-service.service';
import { MatchStatus } from 'src/app/model/match-status.enum';
import { TeamsService } from 'src/app/teams-module/teams-service/teams-service.service';
import { StadiumsService } from 'src/app/stadiums-module/stadiums-service/stadiums-service.service';

@Component({
  selector: 'app-schedules-create',
  templateUrl: './schedules-create.component.html',
  styleUrls: ['./schedules-create.component.css']
})
export class SchedulesCreateComponent implements OnInit {
  match: Match;
  updatedMatch: Match;
  matchFormats: string[] = [];
  matchStatuses: string[] = [];
  teams:Team[]=[];
  stadiums:Stadium[]=[];
  teamOneIndex: number;
  teamTwoIndex: number;
  stadiumIndex:number;
  today: string;

  constructor(private service: SchedulesService, private teamService:TeamsService, private stadiumService:StadiumsService) { 
    this.match = new Match();
    this.teams = [];
    this.today = '2019-11-10T00:00:00';
  }

  ngOnInit() {
    this.matchFormats[0] = MatchFormat.T20;
    this.matchFormats[1] = MatchFormat.ODI;
    this.matchFormats[2] = MatchFormat.TEST;

    this.matchStatuses[0] = MatchStatus.SCHEDULED;
    this.matchStatuses[1] = MatchStatus.ONGOING;

    this.teamService.fetchAllTeams().subscribe(teams => this.teams = teams);

    this.stadiumService.listStadium().subscribe(stadiums => this.stadiums=stadiums);

  }

  addMatch() {
    
    if (this.teamOneIndex != this.teamTwoIndex){
    this.match.teamOne=this.teams[this.teamOneIndex];
    this.match.teamTwo= this.teams[this.teamTwoIndex];
    this.match.matchVenue= this.stadiums[this.stadiumIndex];

    

    this.service.addMatch(this.match).subscribe(data => { this.updatedMatch = data; console.log(this.updatedMatch) })}
    else{
      alert("The two teams cannot be the same!");
    }
   
  }
}
