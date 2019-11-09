import { Component, OnInit, AfterViewInit, AfterViewChecked, AfterContentInit, OnChanges, OnDestroy, AfterContentChecked } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { ArchivesService } from '../archives-service/archives-service.service';
import * as $ from 'jquery';
import { TeamsService } from 'src/app/teams-module/teams-service/teams-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';

@Component({
  selector: 'app-scorecard-view',
  templateUrl: './scorecard-view.component.html',
  styleUrls: ['./scorecard-view.component.css']
})
export class ScorecardViewComponent implements OnInit, BackStack {
  
  receivedMatch: Match;
  wonBy: string;
  
  constructor(private archiveService: ArchivesService, private teamsService: TeamsService, private router: Router) { }

  ngOnInit() {
    $(window).on('popstate', function(event) {
      $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
      $('#archives-outlet').animate({height: '100%', width: '25%'}, 500)
      $('#blogs-outlet').animate({height: '100%', width: '70%'}).show()
    });

    this.onStart();

    this.wonBy = ''
    this.receivedMatch = this.archiveService.transitMatch;
    
    // Check if receivedMatch is empty, if empty - go back.
    this.wonBy = this.receivedMatch.winningTeam.teamName + ' won the match by ' + Math.abs(this.receivedMatch.matchScoreCard.teamOneScore - this.receivedMatch.matchScoreCard.teamTwoScore) + ' runs.'
  }


  onStart() {
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '100%', width: '100%'}, 500).show()
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
  }

  onStop() {
    $('#archives-outlet').animate({height: '0px', width: '0px'}, 500).hide()
  }

  initializeComponent() {
    this.onStart()
  }

  updateMatch() {
    this.teamsService.transitTeam = this.receivedMatch.teamOne
    this.router.navigate([{outlets: {'archives': ['archives-update']}}], {relativeTo: this.archiveService.getParentRoute()});
  }

  viewTeamOne() {
    this.teamsService.transitTeam = this.receivedMatch.teamOne
    this.onStop()
    this.archiveService.addToBackStack(this);
    this.router.navigate([{outlets: {'teams': ['team-view']}}], {relativeTo: this.archiveService.getParentRoute()});
  }

  viewTeamTwo() {
    this.teamsService.transitTeam = this.receivedMatch.teamOne
    this.onStop()
    this.archiveService.addToBackStack(this);
    this.router.navigate([{outlets: {'teams': ['team-view']}}], {relativeTo: this.archiveService.getParentRoute()});
  }
}
