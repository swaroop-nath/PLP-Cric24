import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/model/player.model';
import { RoleType } from 'src/app/model/role-type.enum';
import { PlayersService } from '../players-service/players-service.service';
import { Router } from '@angular/router';
import { Team } from 'src/app/model/team.model';
import { TeamSelection } from 'src/app/model/team-selection.util';

@Component({
  selector: 'app-players-create',
  templateUrl: './players-create.component.html',
  styleUrls: ['./players-create.component.css']
})
export class PlayersCreateComponent implements OnInit {
  player:Player;
  id:number;
  ages:number[]=[];
  roleTypes:string[]=[];
  teamSelection: TeamSelection[];

  constructor(private service: PlayersService,private route: Router) {
    this.player = new Player();
    this.teamSelection = [];
   }

  ngOnInit() {
    this.roleTypes[0]=RoleType.BATSMAN;
    this.roleTypes[1]=RoleType.WICKET_KEEPER;
    this.roleTypes[2]=RoleType.BOWLER;

    for(let i=12;i<100;i++){
      this.ages[i-18]=i;
    }

    this.service.fetchAllTeams().subscribe(teams => {
      teams.forEach(team => this.teamSelection.push(new TeamSelection(team)));
      console.log(teams);
    });
  }

  addPlayer(){
    this.teamSelection.forEach(team => {
      if (team.isChecked)
        this.player.teams.push(team.team)
    });
    this.service.savePlayer(this.player).subscribe(savedPlayer => {
      this.player = savedPlayer;
      // this.route.navigate(['list']);
    });
  }

}
