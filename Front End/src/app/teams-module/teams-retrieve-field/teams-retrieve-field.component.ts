import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team.model';
import { TeamsService } from '../teams-service/teams-service.service';
import { Router } from '@angular/router';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';
import * as $ from 'jquery';

@Component({
  selector: 'app-teams-retrieve-field',
  templateUrl: './teams-retrieve-field.component.html',
  styleUrls: ['./teams-retrieve-field.component.css']
})
export class TeamsRetrieveFieldComponent implements OnInit, BackStack {
  
  teams: Team[];
  teamName: string;
  fetchId:number;
  submitted: boolean = false;

  constructor(private service: TeamsService, private router: Router) {}

  ngOnInit() {
    this.teams = [];
  }

  onStart() {
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#players-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#stadiums-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#teams-outlet').animate({height: '100%', width: '100%'}).show()
  }

  initializeComponent() {
    this.onStart();
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

  viewTeam(team) {
    this.service.transitTeam = team;
    this.service.addToBackStack(this);
    this.router.navigate([{outlets: {'teams': ['team-view']}}], {relativeTo: this.service.getParentRoute()})
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
