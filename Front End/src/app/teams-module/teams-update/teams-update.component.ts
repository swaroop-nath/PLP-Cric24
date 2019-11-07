import { Component, OnInit } from '@angular/core';
import { MatchFormat } from 'src/app/model/match-format.enum';
import { TeamsService } from '../teams-service/teams-service.service';
import { Team } from 'src/app/model/team.model';
import { Router } from '@angular/router';
import { PlayerSelection } from 'src/app/model/player-selection.util';

@Component({
  selector: 'app-teams-update',
  templateUrl: './teams-update.component.html',
  styleUrls: ['./teams-update.component.css']
})
export class TeamsUpdateComponent implements OnInit {

  team:Team;
  submitted:boolean=false;
  ranking:number;
  matchFormats:string[]= [];
  playerSelection: PlayerSelection[];

  constructor(private service:TeamsService, private route:Router) { 
    this.playerSelection = [];
  }

  ngOnInit() {
    this.matchFormats[0]= MatchFormat.ODI;
    this.matchFormats[1]= MatchFormat.T20;
    this.matchFormats[2]= MatchFormat.TEST;
    this.team = this.service.transitTeam;
    console.log(this.team)
    this.service.fetchAllPlayers().subscribe(fetchedPlayers => {
      fetchedPlayers.forEach(player => {
        let flag = false;
        this.team.players.forEach(existentPlayer => {
          if (player.playerId === existentPlayer.playerId) {
            flag = true;
          }
        });
        if (!flag)
          this.playerSelection.push(new PlayerSelection(player))
      });
      console.log(this.playerSelection)
    });
  }

  update(){
    this.playerSelection.forEach(player => {
      if (player.isChecked)
        this.team.players.push(player.player)
    });
    console.log(this.team)
    this.service.updateTeam(this.team).subscribe(data => {
      this.team=data;
      this.submitted=true;
    });
    this.team=new Team();
    }
  
}
