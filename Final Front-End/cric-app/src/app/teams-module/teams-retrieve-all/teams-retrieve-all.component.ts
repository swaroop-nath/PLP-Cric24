import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team.model';
import { TeamsService } from '../teams-service/teams-service.service';
import { Router } from '@angular/router';
import * as $ from 'jquery';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';

@Component({
  selector: 'app-teams-retrieve-all',
  templateUrl: './teams-retrieve-all.component.html',
  styleUrls: ['./teams-retrieve-all.component.css']
})
export class TeamsRetrieveAllComponent implements OnInit, BackStack {

  teams:Team[];
  constructor(private service:TeamsService, private router: Router) { }

  ngOnInit() {
    this.teams = [];
    this.service.fetchAllTeams().subscribe(fetchedTeams => {
      fetchedTeams.sort((matchOne, matchTwo) => matchOne.ranking - matchTwo.ranking)
      this.teams = fetchedTeams;
    });
    this.onStart();

    $(window).on('popstate', function(event) {
      $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
      $('#archives-outlet').animate({height: '100%', width: '25%'}, 500).show()
      $('#blogs-outlet').animate({height: '100%', width: '70%'}).show()
      $('#teams-outlet').animate({height: '0px', width: '0px'}).hide()
    });
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
    // Write initialization code here
    this.onStart()
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

  findTeams() {
    this.router.navigate([{outlets: {'teams': ['find-teams']}}], {relativeTo: this.service.getParentRoute()})
  }

}
