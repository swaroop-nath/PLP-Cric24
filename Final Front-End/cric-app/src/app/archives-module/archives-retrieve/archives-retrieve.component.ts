import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { ArchivesService } from '../archives-service/archives-service.service';
import { MatchFormat } from 'src/app/model/match-format.enum';
import { Router, ActivatedRoute } from '@angular/router';

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

  constructor(private archivesService: ArchivesService, private router: Router, private route: ActivatedRoute) {
    this.matches_view = [];
  }

  ngOnInit() {
    this.archivesService.fetchAllMatches().subscribe(fetchedMatches => {
      this.archivesService.saveFetchedMatches(fetchedMatches);
      
      this.archivesService.matches_master.forEach(fetchedMatch => {
        if (fetchedMatch.matchSchedule.getFullYear() == 2019)
          this.matches_view.push(fetchedMatch);
      });
    });
  }

  viewScoreCard(index: number) {
    this.archivesService.transitMatch = this.matches_view[index];
    this.router.navigate(['/scorecard-view', {outlets: 'archives'}]);
  }

}
