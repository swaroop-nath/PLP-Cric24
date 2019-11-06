import { Component, OnInit } from '@angular/core';
import { Player } from '../model/player';
import { PlayerService } from '../player/player.service';
import { RoleType } from '../model/role-type.enum';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  player:Player;
  submitted:boolean=false;
  ages:number[]=[];
  roleTypes:string[]=[];

  constructor(private service:PlayerService) {
    this.player=new Player();
   }

  ngOnInit() {
    this.roleTypes[0]=RoleType.BATSMAN;
    this.roleTypes[1]=RoleType.WICKET_KEEPER;
    this.roleTypes[2]=RoleType.BOWLER;

    for(let i=12;i<100;i++){
      this.ages[i-18]=i;
    }
  }

  updatePlayer(){
    this.service.updatePlayer(this.player).subscribe(data=>{
      this.player=data;
      this.submitted=true;
    });
    this.player=new Player();
  }

}
