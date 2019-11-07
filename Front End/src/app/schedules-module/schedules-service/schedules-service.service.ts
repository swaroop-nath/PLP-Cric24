import { Injectable } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { Team } from 'src/app/model/team.model';
import { Player } from 'src/app/model/player.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SchedulesService {
  match:Match;
  matches:Match[];
  team: Team;
  teams:Team[];
  player:Player;
  players:Player[];

  constructor(public httpClient: HttpClient) { }

  addMatch(match:Match):Observable<Match>{
    return this.httpClient.post<Match>("http://localhost:8085/schedule/addMatch", match);
  }

  listMatch():Observable<any>{
    return this.httpClient.get("http://localhost:8085/schedule/getMatches")
  }

  updateMatch(match:Match):Observable<Match>{
    return this.httpClient.put<Match>("http://localhost:8085/schedule/updateMatch", match);
  }

  fetchAllTeams():Observable<any> {
    return this.httpClient.get("http://localhost:8888/team/all");
  }

  fetchAllStadiums():Observable<any>{
    return this.httpClient.get("http://localhost:8890/stadium/all");
  }

  setUpdateMatch(match:Match){
    this.match = match;
  }

  getUpdateMatch(){
    return this.match;
  }
}
