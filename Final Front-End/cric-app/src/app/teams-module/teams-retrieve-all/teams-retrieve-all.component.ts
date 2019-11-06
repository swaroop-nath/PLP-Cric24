import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team.model';
import { TeamsService } from '../teams-service/teams-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teams-retrieve-all',
  templateUrl: './teams-retrieve-all.component.html',
  styleUrls: ['./teams-retrieve-all.component.css']
})
export class TeamsRetrieveAllComponent implements OnInit {
  teams:Team[];
  constructor(private service:TeamsService, private router: Router) { }

  ngOnInit() {
    this.service.fetchAllTeams().subscribe(fetchedTeams => this.teams = fetchedTeams);
  }

  updateTeam(team: Team) {
    console.log(team)
    this.service.transitTeam = team;
    this.router.navigate(['teams-update']);
  }
}
