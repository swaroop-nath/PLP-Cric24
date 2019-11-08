import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { Router } from '@angular/router';
import { SchedulesService } from '../schedules-service/schedules-service.service';
import { AfterBadRoute } from 'src/app/cricket-service/after-bad-route.interface';

@Component({
  selector: 'app-schedules-retrieve',
  templateUrl: './schedules-retrieve.component.html',
  styleUrls: ['./schedules-retrieve.component.css']
})
export class SchedulesRetrieveComponent implements OnInit, AfterBadRoute {
  matches : Match[] = [];

  constructor(private service: SchedulesService, private router:Router) { }

  ngOnInit() {
    this.service.listMatch().subscribe(data =>this.matches = data);
  }

  onBadRouteProvided() {
    this.service.listMatch().subscribe(data =>this.matches = data);
  }

  // fetchData(match:Match){
  //   this.service.setUpdateMatch(match);
  //   this.route.navigate(['update'])
  // }

  viewSchedule(match: Match) {
    // route to view match and update there
    this.service.transitSchedule = match;
    this.router.navigate([{outlets: {'schedules': ['schedule-view']}}], {relativeTo: this.service.getParentRoute()});
  }
}
