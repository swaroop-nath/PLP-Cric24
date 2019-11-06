import { Injectable } from '@angular/core';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { Team } from 'src/app/model/team.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamsService {

  private BASE_URL = "http://localhost:8888/team";
  private LIST_ALL_EXT = '/all';

  constructor(private cricService: CricketService) { }

  public fetchAllTeams(): Observable<Team[]> {
    return this.cricService.fetchAll<Team>(this.BASE_URL + this.LIST_ALL_EXT);
  }
}
