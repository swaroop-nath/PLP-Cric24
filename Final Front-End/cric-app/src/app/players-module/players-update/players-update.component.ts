import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/model/player.model';
import { RoleType } from 'src/app/model/role-type.enum';
import { PlayersService } from '../players-service/players-service.service';
import { TeamSelection } from 'src/app/model/team-selection.util';

@Component({
  selector: 'app-players-update',
  templateUrl: './players-update.component.html',
  styleUrls: ['./players-update.component.css']
})
export class PlayersUpdateComponent implements OnInit {
  player:Player;
  submitted:boolean=false;
  ages:number[]=[];
  roleTypes:string[]=[];
  teamSelection: TeamSelection[];

  constructor(private service:PlayersService) {}

  ngOnInit() {
    this.roleTypes[0]=RoleType.BATSMAN;
    this.roleTypes[1]=RoleType.WICKET_KEEPER;
    this.roleTypes[2]=RoleType.BOWLER;

    this.player=this.service.transitPlayer
    this.teamSelection = []

    for(let i=12;i<100;i++){
      this.ages[i-18]=i;
    }

    this.service.fetchAllTeams().subscribe(fetchedTeams => {
      fetchedTeams.forEach(fetchedTeam => {
        let flag = true;
        this.player.teams.forEach(existingTeam => {
          if (fetchedTeam.teamId == existingTeam.teamId) {
            flag = false;
          }
        });
        if (flag)
          this.teamSelection.push(new TeamSelection(fetchedTeam))
      });
    });
  }

  updatePlayer(){
    this.teamSelection.forEach(team => {
      if (team.isChecked)
        this.player.teams.push(team.team)
    });
    this.service.updatePlayer(this.player).subscribe(data=>{
      this.player=data;
      this.submitted=true;
    });
    this.player=new Player();
  }

}
