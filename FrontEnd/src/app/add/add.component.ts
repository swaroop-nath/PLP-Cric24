import { Component, OnInit } from '@angular/core';
import { MatchFormat } from '../model/match-format.enum';
import { Team } from '../model/team';
import { TeamService } from '../team/team.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  team:Team;
  id:number;
  ranking:number;
  matchFormats:string[]= [];

  constructor(private service:TeamService, private route:Router) {
    this.team =new Team();
   }

  ngOnInit() {
    this.matchFormats[0]= MatchFormat.ODI;
    this.matchFormats[1]= MatchFormat.T20;
    this.matchFormats[2]= MatchFormat.TEST;
  }
  addTeam(){
    this.service.saveTeam(this.team).subscribe(p => this.team = p);
    console.log(this.team);
    this.team = new Team();
    // this.route.navigate(['list']);
    
  }


}
