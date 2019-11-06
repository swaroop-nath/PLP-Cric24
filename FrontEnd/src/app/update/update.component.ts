import { Component, OnInit } from '@angular/core';
import { TeamService } from '../team/team.service';
import { Router } from '@angular/router';
import { Team } from '../model/team';
import { MatchFormat } from '../model/match-format.enum';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  team:Team;
  submitted:boolean=false;
  ranking:number;
  matchFormats:string[]= [];

  constructor(private service:TeamService, private route:Router) { 
    this.team=new Team();
  }

  ngOnInit() {
    this.matchFormats[0]= MatchFormat.ODI;
    this.matchFormats[1]= MatchFormat.T20;
    this.matchFormats[2]= MatchFormat.TEST;
  }

  update(){
    this.service.updateTeam(this.team).subscribe(data => {
      this.team=data;
      this.submitted=true;
    });
    this.team=new Team();
    }
  }
