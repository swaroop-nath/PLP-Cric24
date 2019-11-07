import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { ArchivesService } from '../archives-service/archives-service.service';
import * as $ from 'jquery';
import { TeamsService } from 'src/app/teams-module/teams-service/teams-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';

@Component({
  selector: 'app-scorecard-view',
  templateUrl: './scorecard-view.component.html',
  styleUrls: ['./scorecard-view.component.css']
})
export class ScorecardViewComponent implements OnInit {

  receivedMatch: Match;
  wonBy: string;
  
  constructor(private archiveService: ArchivesService, private teamsService: TeamsService, private cricService: CricketService, private router: Router) { }

  ngOnInit() {
    $(window).on('popstate', function(event) {
      $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
      $('#archives-outlet').animate({height: '100%', width: '25%'}, 500)
      $('#blogs-outlet').animate({height: '100%', width: '70%'}).show()
      $('#schedules-outlet-child').show()
      $('#blogs-outlet-child').show()
     });
    this.wonBy = ''
    this.receivedMatch = this.archiveService.transitMatch;
    this.createView()

    this.wonBy = this.receivedMatch.winningTeam.teamName + ' won the match by ' + Math.abs(this.receivedMatch.matchScoreCard.teamOneScore - this.receivedMatch.matchScoreCard.teamTwoScore) + ' runs.'
  }

  createView() {
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '100%', width: '100%'}, 500)
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#schedules-outlet-child').hide()
    $('#blogs-outlet-child').hide()
  }

  onForward() {
    $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
    $('#archives-outlet').animate({height: '100%', width: '25%'}, 500)
    $('#blogs-outlet').animate({height: '100%', width: '70%'}).show()
    $('#schedules-outlet-child').show()
    $('#blogs-outlet-child').show()
  }

  viewTeamOne() {
    this.teamsService.transitTeam = this.receivedMatch.teamOne
    this.onForward()
    this.router.navigate([{outlets: {'teams': ['team-view']}}], {relativeTo: this.cricService.parentRoute});
  }

  viewTeamTwo() {
    this.teamsService.transitTeam = this.receivedMatch.teamOne
    this.onForward()
    this.router.navigate([{outlets: {'teams': ['team-view']}}], {relativeTo: this.cricService.parentRoute});
  }
}
