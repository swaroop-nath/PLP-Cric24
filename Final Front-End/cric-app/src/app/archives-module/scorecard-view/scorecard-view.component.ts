import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { ArchivesService } from '../archives-service/archives-service.service';

@Component({
  selector: 'app-scorecard-view',
  templateUrl: './scorecard-view.component.html',
  styleUrls: ['./scorecard-view.component.css']
})
export class ScorecardViewComponent implements OnInit {

  receivedMatch: Match;
  
  constructor(private archiveService: ArchivesService) { }

  ngOnInit() {
    this.receivedMatch = this.archiveService.transitMatch;
    console.log(this.receivedMatch)
  }

}
