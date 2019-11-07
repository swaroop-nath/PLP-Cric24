import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team.model';
import { TeamsService } from '../teams-service/teams-service.service';

@Component({
  selector: 'app-team-view',
  templateUrl: './team-view.component.html',
  styleUrls: ['./team-view.component.css']
})
export class TeamViewComponent implements OnInit {

  receivedTeam: Team;
  constructor(private service: TeamsService) { }

  ngOnInit() {
    this.receivedTeam = this.service.transitTeam;
  }

}
