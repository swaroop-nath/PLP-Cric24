import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { ArchivesService } from '../archives-service/archives-service.service';
import { MatchFormat } from 'src/app/model/match-format.enum';

@Component({
  selector: 'app-archives-retrieve',
  templateUrl: './archives-retrieve.component.html',
  styleUrls: ['./archives-retrieve.component.css']
})
export class ArchivesRetrieveComponent implements OnInit {

  matches_view: Match[];
  t20_matches: Match[];
  odi_matches: Match[];
  test_matches: Match[];

  constructor(private archivesService: ArchivesService) {
    this.matches_view = [];
    this.t20_matches = [];
    this.odi_matches = [];
    this.test_matches = [];
  }

  ngOnInit() {
    this.archivesService.fetchAllMatches().subscribe(fetchedMatches => {
      this.archivesService.saveFetchedMatches(fetchedMatches);
      this.t20_matches = this.archivesService.matches_master.filter(match => match.matchFormat === MatchFormat.T20 && match.matchSchedule.getFullYear() === 2019);
      this.odi_matches = this.archivesService.matches_master.filter(match => match.matchFormat === MatchFormat.ODI && match.matchSchedule.getFullYear() === 2019);
      this.t20_matches = this.archivesService.matches_master.filter(match => match.matchFormat === MatchFormat.TEST && match.matchSchedule.getFullYear() === 2019);

      this.t20_matches.forEach(t20_match => this.matches_view.push(t20_match));
      this.odi_matches.forEach(odi_match => this.matches_view.push(odi_match));
      this.test_matches.forEach(test_match => this.matches_view.push(test_match));

    });
  }

}
