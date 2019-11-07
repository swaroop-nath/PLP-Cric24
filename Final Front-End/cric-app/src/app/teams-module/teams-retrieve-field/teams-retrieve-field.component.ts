import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team.model';
import { TeamsService } from '../teams-service/teams-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teams-retrieve-field',
  templateUrl: './teams-retrieve-field.component.html',
  styleUrls: ['./teams-retrieve-field.component.css']
})
export class TeamsRetrieveFieldComponent implements OnInit {
  teams: Team[];
  teamName: string;
  fetchId:number;
  submitted: boolean = false;

  constructor(private service: TeamsService, private router: Router) {}

  ngOnInit() {
    this.teams = [];
  }

  findTeamById(){
    this.teams = [];
    this.service.findTeamById(this.fetchId).subscribe(fetchedTeam =>{
      this.teams.push(fetchedTeam);
      this.submitted = true;
    });
  }
  findTeamByName() {
    this.teams = [];
    this.service.findTeamByName(this.teamName).subscribe(fetchedTeams => {
      this.teams = fetchedTeams;
      this.submitted = true;
    });
  }

  updateTeam(team: Team) {
    this.service.transitTeam = team;
    this.router.navigate([{outlets: {'teams': ['update-team']}}], {relativeTo: this.service.getParentRoute()})
  }

  deleteTeam(index: number) {
    let idDelete = this.teams[index].teamId;
    var ans = confirm("Are You Sure You want to delete?")
    if(ans){
      this.teams.splice(index,1)
      this.service.deleteTeam(idDelete).subscribe(); // delete from service
    }
  }
}
