import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team.model';
import { MatchFormat } from 'src/app/model/match-format.enum';
import { TeamsService } from '../teams-service/teams-service.service';
import { Router } from '@angular/router';
import { PlayerSelection } from 'src/app/model/player-selection.util';

@Component({
  selector: 'app-teams-create',
  templateUrl: './teams-create.component.html',
  styleUrls: ['./teams-create.component.css']
})
export class TeamsCreateComponent implements OnInit {
  team:Team;
  id:number;
  ranking:number;
  matchFormats:string[]= [];
  playerSelection: PlayerSelection[];

  constructor(private service: TeamsService, private route:Router) {
    this.team =new Team();
    this.playerSelection = [];
   }

  ngOnInit() {
    this.matchFormats[0]= MatchFormat.ODI;
    this.matchFormats[1]= MatchFormat.T20;
    this.matchFormats[2]= MatchFormat.TEST;
    this.service.fetchAllPlayers().subscribe(players => {
      players.forEach(playerFetched => this.playerSelection.push(new PlayerSelection(playerFetched)));
    });
  }
  addTeam(){
    this.service.saveTeam(this.team).subscribe(p => this.team = p);
    console.log(this.team);
    this.team = new Team();
    // this.route.navigate(['list']);
    
  }
}
