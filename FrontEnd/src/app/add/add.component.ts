import { Component, OnInit } from '@angular/core';
import { Player } from '../model/player';
import { PlayerService } from '../player/player.service';
import { Router } from '@angular/router';
import { MatchFormat } from '../model/match-format.enum';
import { RoleType } from '../model/role-type.enum';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  player:Player;
  id:number;
  ages:number[]=[];
  roleTypes:string[]=[];

  constructor(private service:PlayerService,private route:Router) {
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

  addPlayer(){
    this.service.savePlayer(this.player).subscribe(p=>this.id=p);
    this.player=new Player();
    this.route.navigate(['list']);
  }

}
