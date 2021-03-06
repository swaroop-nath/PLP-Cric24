import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { ArchivesService } from '../archives-service/archives-service.service';
import { MatchFormat } from 'src/app/model/match-format.enum';
import { Router, ActivatedRoute } from '@angular/router';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { AfterBadRoute } from 'src/app/cricket-service/after-bad-route.interface';

@Component({
  selector: 'app-archives-retrieve',
  templateUrl: './archives-retrieve.component.html',
  styleUrls: ['./archives-retrieve.component.css']
})
export class ArchivesRetrieveComponent implements OnInit, AfterBadRoute {

  matches_view: Match[];
  t20_matches: Match[];
  odi_matches: Match[];
  test_matches: Match[];

  constructor(private archivesService: ArchivesService, private router: Router, private cricService: CricketService) {
    this.matches_view = [];
  }

  ngOnInit() {
    this.initialize();
    this.archivesService.addToHomeStack(this);
  }

  onBadRouteProvided() {
    console.log('bad route called');
    
    this.initialize();
  }

  initialize() {
    this.archivesService.fetchAllMatches().subscribe(fetchedMatches => {
      this.archivesService.saveFetchedMatches(fetchedMatches);
      console.log(fetchedMatches.length);
      
      this.archivesService.matches_master.forEach(fetchedMatch => {
        if (true) // Change this
          this.matches_view.push(fetchedMatch);
      });
    });
  }

  viewScoreCard(index: number) {
    this.archivesService.transitMatch = this.matches_view[index];
    this.router.navigate([{outlets: {'archives': ['scorecard-view']}}], {relativeTo: this.archivesService.getParentRoute()});
  }

}
