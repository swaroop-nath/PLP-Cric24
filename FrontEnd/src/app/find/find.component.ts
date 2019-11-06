import { Component, OnInit } from '@angular/core';
import { Team } from '../model/team';
import { TeamService } from '../team/team.service';
import { p } from '@angular/core/src/render3';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit {
  teams: Team;
  t:Team;
  teamName: string;
  teamId:number;
  submitted: boolean = false;


  constructor(private service: TeamService) {

  }

  ngOnInit() {
    this.t = new Team();
  }

  findTeamById(){
    this.service.findTeamById(this.teamId).subscribe(p=>{
      this.t= p;
      this.submitted = true;
    });
  }
  findTeamByName() {
    this.service.findTeamByName(this.teamName).subscribe(p => {
      this.teams = p;
      this.submitted = true;
    });
  }
}
