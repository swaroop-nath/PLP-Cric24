import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Team } from 'src/app/model/team.model';
import { TeamsService } from '../teams-service/teams-service.service';
import * as $ from 'jquery';
import { Match } from 'src/app/model/match.model';
import { MatchStatus } from 'src/app/model/match-status.enum';
import { Router } from '@angular/router';

@Component({
  selector: 'app-team-view',
  templateUrl: './team-view.component.html',
  styleUrls: ['./team-view.component.css']
})
export class TeamViewComponent implements OnInit {
 
  receivedTeam: Team;
  wins = 0;
  losses = 0;
  draws = 0;
  matchesForTeam: Match[];

  constructor(private service: TeamsService, private router: Router) { }

  ngOnInit() {
    this.receivedTeam = this.service.transitTeam;

    this.service.fetchMatchesByTeam(this.receivedTeam).subscribe(fetchedMatches => {
      this.matchesForTeam = fetchedMatches;

      fetchedMatches.forEach(match => {
        if(match.matchStatus === MatchStatus.CONCLUDED && match.winningTeam.teamId == this.receivedTeam.teamId)
          this.wins += 1;
        else if ((match.matchStatus === MatchStatus.CONCLUDED && match.winningTeam.teamId != this.receivedTeam.teamId) || (match.matchStatus === MatchStatus.FORFEITED))
          this.losses += 1;
        else 
          this.draws += 1;
      });
    });

    this.onStart()

    $(window).on('popstate', (event) => {
      $('#teams-outlet').animate({height: '0px', width: '0px'}).hide()
      this.service.getFromBackStack().initializeComponent();
    });
  }

  onStart() {
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#teams-outlet').animate({height: '100%', width: '100%'}).show()
  }

  //TODO: Have an update team button here for admin

  updateTeam(team: Team) {
    this.service.transitTeam = team;
    this.router.navigate([{outlets: {'teams': ['update-team']}}], {relativeTo: this.service.getParentRoute()})
  }

}
