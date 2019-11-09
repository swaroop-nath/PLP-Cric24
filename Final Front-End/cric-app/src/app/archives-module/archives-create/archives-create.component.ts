import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { Team } from 'src/app/model/team.model';
import { Stadium } from 'src/app/model/stadium.model';
import { MatchFormat } from 'src/app/model/match-format.enum';
import { MatchStatus } from 'src/app/model/match-status.enum';
import { ArchivesService } from '../archives-service/archives-service.service';
import { TeamsService } from 'src/app/teams-module/teams-service/teams-service.service';
import { StadiumsService } from 'src/app/stadiums-module/stadiums-service/stadiums-service.service';
import * as $ from 'jquery';
import { Player } from 'src/app/model/player.model';
import { PlayersService } from 'src/app/players-module/players-service/players-service.service';
import { ScoreCard } from 'src/app/model/scorecard.model';

@Component({
  selector: 'app-archives-create',
  templateUrl: './archives-create.component.html',
  styleUrls: ['./archives-create.component.css']
})
export class ArchivesCreateComponent implements OnInit {
  match: Match;
  matchFormats: string[] = [];
  matchStatuses: string[] = [];
  teams_master:Team[]=[];
  teams_one_view: Team[] = [];
  teams_two_view: Team[] = [];
  winnings_team_view: Team[] = [];
  players_master: Player[] = [];
  players_view: Player[] = [];
  teamOne: Team;
  teamTwo: Team;
  stadiums:Stadium[]=[];
  teamOneIndex: number;
  teamTwoIndex: number;
  winningTeamIndex: number;
  stadiumIndex:number;
  today: string;

  constructor(private archiveService: ArchivesService, private teamService:TeamsService, 
    private stadiumService:StadiumsService, private playerService: PlayersService) {
    this.match = new Match();
    this.teams_master = [];
    this.teamOne = new Team();
    this.teamTwo = new Team();
    this.match.matchScoreCard = new ScoreCard();
    this.today = '2019-11-10T00:00:00';
  }

  ngOnInit() {
    this.matchFormats[0] = MatchFormat.T20;
    this.matchFormats[1] = MatchFormat.ODI;
    this.matchFormats[2] = MatchFormat.TEST;

    this.matchStatuses[0] = MatchStatus.SCHEDULED;
    this.matchStatuses[1] = MatchStatus.ONGOING;

    this.teamService.fetchAllTeams().subscribe(teams => {
      this.teams_master = teams;
      console.log(teams.length);
      
      this.teams_one_view = this.teams_master;
      this.teams_two_view = this.teams_master;
    });

    this.playerService.listPlayer().subscribe(players => {
      this.players_master = players;
    });

    this.stadiumService.listStadium().subscribe(stadiums => this.stadiums=stadiums);

    $('#teamOneSelect').on('change', () => {
      this.teamOne = this.teams_one_view[this.teamOneIndex]
      this.teams_two_view = []
      this.teams_master.forEach(team => {
        if (team.teamId != this.teamOne.teamId)
          this.teams_two_view.push(team);
      });

      this.winnings_team_view = [];
      this.players_view = [];
      this.winnings_team_view.push(this.teamOne);
      this.players_view.concat(this.teamOne.players);

      if (this.teamTwoIndex != undefined) {
        this.winnings_team_view.push(this.teamTwo)
        this.players_view.concat(this.teamTwo.players)
      }
      
    });

    $('#teamTwoSelect').on('change', () => {
      this.teamTwo = this.teams_two_view[this.teamTwoIndex];

      this.winnings_team_view = [];
      this.players_view = [];
      this.winnings_team_view.push(this.teamTwo);
      this.players_view.concat(this.teamTwo.players);

      if (this.teamOneIndex != undefined) {
        this.winnings_team_view.push(this.teamOne)
        this.players_view.concat(this.teamOne.players)
      }
    });
  }

  addMatch() {
    
  //   if (this.teamOneIndex != this.teamTwoIndex){
  //   this.match.teamOne=this.teams_view[this.teamOneIndex];
  //   this.match.teamTwo= this.teams_view[this.teamTwoIndex];
  //   this.match.matchVenue= this.stadiums[this.stadiumIndex];

  //   this.archiveService.persistMatchDetails(this.match).subscribe()
  // }else{
  //     alert("The two teams cannot be the same!");
  // }
   
  }

}
