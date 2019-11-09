import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { Team } from 'src/app/model/team.model';
import { Player } from 'src/app/model/player.model';
import { Stadium } from 'src/app/model/stadium.model';
import * as $ from 'jquery';
import { ArchivesService } from '../archives-service/archives-service.service';
import { TeamsService } from 'src/app/teams-module/teams-service/teams-service.service';
import { StadiumsService } from 'src/app/stadiums-module/stadiums-service/stadiums-service.service';
import { MatchFormat } from 'src/app/model/match-format.enum';
import { MatchStatus } from 'src/app/model/match-status.enum';
import { ScoreCard } from 'src/app/model/scorecard.model';

@Component({
  selector: 'app-archives-update',
  templateUrl: './archives-update.component.html',
  styleUrls: ['./archives-update.component.css']
})
export class ArchivesUpdateComponent implements OnInit {
  match: Match;
  matchFormats: string[] = [];
  matchStatuses: string[] = [];
  teams_master:Team[]=[];
  teams_one_view: Team[] = [];
  teams_two_view: Team[] = [];
  winnings_team_view: Team[] = [];
  players_view: Player[] = [];
  playerOfTheMatchIndex: number;
  teamOne: Team;
  teamTwo: Team;
  stadiums:Stadium[]=[];
  teamOneIndex: number;
  teamTwoIndex: number;
  winningTeamIndex: number;
  stadiumIndex:number;
  today: string;
  isMatchCancelled: boolean = false

  constructor(private archiveService: ArchivesService, private teamService:TeamsService, 
    private stadiumService:StadiumsService) { 
    this.match = archiveService.transitMatch;
    this.teams_master = [];
    this.teamOne = new Team();
    this.teamTwo = new Team();
    this.today = '2019-11-10T00:00:00';
  }

  ngOnInit() {
    this.matchFormats[0] = MatchFormat.T20;
    this.matchFormats[1] = MatchFormat.ODI;
    this.matchFormats[2] = MatchFormat.TEST;

    this.matchStatuses[0] = MatchStatus.CONCLUDED;
    this.matchStatuses[1] = MatchStatus.FORFEITED;
    this.matchStatuses[2] = MatchStatus.CANCELLED;

    this.winnings_team_view = [this.match.teamOne, this.match.teamTwo]
    this.match.teamOne.players.forEach(player => this.players_view.push(player))
    this.match.teamTwo.players.forEach(player => this.players_view.push(player))
    
    if (this.match.matchScoreCard = null) {
      this.match.matchScoreCard = new ScoreCard();
    }

    if (this.match.matchScoreCard.playerOfTheMatch != null) {
      this.players_view.forEach((player, index) => {
        console.log(this.match.matchScoreCard.playerOfTheMatch);
        
        if (player.playerId == this.match.matchScoreCard.playerOfTheMatch.playerId)
          this.playerOfTheMatchIndex = index;
      })
    }

    this.teamService.fetchAllTeams().subscribe(teams => {
      this.teams_master = teams;
      
      this.teams_one_view = this.teams_master;
      this.teams_two_view = this.teams_master;

      this.teams_master.forEach((team, index) => {
        if (team.teamId == this.match.teamOne.teamId)
          this.teamOneIndex = index;
        if (team.teamId == this.match.teamTwo.teamId)
          this.teamTwoIndex = index;
        if (this.match.winningTeam != null && team.teamId == this.match.winningTeam.teamId)
          this.winningTeamIndex = index;
      });

    });

    this.stadiumService.listStadium().subscribe(stadiums => {
      this.stadiums=stadiums;
      stadiums.forEach((stadium, index) => {
        if (this.match.matchVenue.stadiumId == stadium.stadiumId)
          this.stadiumIndex = index;
      })
    });

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
      this.teamOne.players.forEach(player => this.players_view.push(player));

      if (this.teamTwoIndex != undefined) {
        this.winnings_team_view.push(this.teamTwo)
        this.teamTwo.players.forEach(player => this.players_view.push(player));
      }
    });

    $('#teamTwoSelect').on('change', () => {
      this.teamTwo = this.teams_two_view[this.teamTwoIndex];

      this.winnings_team_view = [];
      this.players_view = [];
      this.winnings_team_view.push(this.teamTwo);
      this.teamTwo.players.forEach(player => this.players_view.push(player));

      if (this.teamOneIndex != undefined) {
        this.winnings_team_view.push(this.teamOne)
        this.players_view.concat(this.teamOne.players);
        this.teamOne.players.forEach(player => this.players_view.push(player));
      }
    });

    $('#matchStatus').on('change', () => {
      if (this.match.matchStatus == MatchStatus.CANCELLED) 
        this.isMatchCancelled = true;
      else
        this.isMatchCancelled = false;
    });
  }

  updateMatch() {

    this.match.teamOne = this.teamOne;
    this.match.teamTwo = this.teamTwo;
    this.match.matchVenue = this.stadiums[this.stadiumIndex]
    this.match.winningTeam = this.winnings_team_view[this.winningTeamIndex];
    this.match.matchScoreCard.teamOne = this.teamOne;
    this.match.matchScoreCard.teamTwo = this.teamTwo;
    this.match.matchScoreCard.playerOfTheMatch = this.players_view[this.playerOfTheMatchIndex]

    console.log(this.match);
    
    this.archiveService.persistMatchDetails(this.match).subscribe(data => alert('Done'));
   
  }

}
