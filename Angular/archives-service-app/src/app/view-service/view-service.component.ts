import { Component, OnInit } from '@angular/core';
import { Match } from '../model/match.model';
import { ArchivesService } from '../archives-service/archives-service.service';

@Component({
  selector: 'app-view-service',
  templateUrl: './view-service.component.html',
  styleUrls: ['./view-service.component.css']
})
export class ViewServiceComponent implements OnInit {

  matches_master: Match[];
  matches_view: Match[];
  odi_matches: Match[];
  t20_matches: Match[];
  test_match: Match[];
  
  constructor(private service: ArchivesService) { }

  ngOnInit() {
    if (this.matches_master.length == 0) {
      this.service.viewAllMatches().subscribe(data => {
        this.matches_master = data;
        this.matches_view = this.matches_master;
      });
    } else {
        this.matches_view = this.matches_master;
    }
    // Contact teams service to get the list of teams
  }

  groupByTeam(){

  }

}
