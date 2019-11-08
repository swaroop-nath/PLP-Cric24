import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { Match } from 'src/app/model/match.model';
import { SchedulesService } from '../schedules-service/schedules-service.service';
import { TeamsService } from 'src/app/teams-module/teams-service/teams-service.service';
import { Router } from '@angular/router';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';

@Component({
  selector: 'app-schedule-view',
  templateUrl: './schedule-view.component.html',
  styleUrls: ['./schedule-view.component.css']
})
export class ScheduleViewComponent implements OnInit, BackStack {

  receivedMatch: Match;
  constructor(private service: SchedulesService, private teamsService: TeamsService, private router: Router) { }

  ngOnInit() {
    $(window).on('popstate', function(event) {
      $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
      $('#archives-outlet').animate({height: '100%', width: '25%'}, 500)
      $('#blogs-outlet').animate({height: '100%', width: '70%'}).show()
    });

    this.receivedMatch = this.service.transitSchedule;

  }

  initializeComponent() {
    $('#schedules-outlet').animate({height: '100%', width: '100%'}, 500).show()
  }
  
  onStart() {
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#schedules-outlet').animate({height: '100%', width: '100%'}, 500).show()
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
  }

  onStop() {
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
  }

  viewTeamOne() {
    this.teamsService.transitTeam = this.receivedMatch.teamOne
    this.onStop()
    this.service.addToBackStack(this);
    this.router.navigate([{outlets: {'teams': ['team-view']}}], {relativeTo: this.service.getParentRoute()});
  }

  viewTeamTwo() {
    this.teamsService.transitTeam = this.receivedMatch.teamOne
    this.onStop()
    this.service.addToBackStack(this);
    this.router.navigate([{outlets: {'teams': ['team-view']}}], {relativeTo: this.service.getParentRoute()});
  }

  updateSchedule() {
    // navigate to update
    this.service.transitSchedule = this.receivedMatch
    this.onStop()
    this.service.addToBackStack(this);
    this.router.navigate([{outlets: {'schedules': ['schedules-update']}}], {relativeTo: this.service.getParentRoute()});
  }
}
