import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Match } from '../model/match.model';
import { HttpClient } from '@angular/common/http';
import { Team } from '../model/team.model';

@Injectable({
  providedIn: 'root'
})
export class ArchivesService {

  BASE_URL = 'http://localhost:7170/archives-api';
  LIST_ALL_EXT = '/list-matches';
  LIST_BY_TEAM_EXT = '/list-matches/by-team';
  UPDATE_EXT = '/update-match';
  ADD_EXT = '/add-match';

  constructor(private client: HttpClient) { }

  public viewAllMatches(): Observable<Match[]> {
    return this.client.get<Match[]>(this.BASE_URL + this.LIST_ALL_EXT);
  }

  public viewAllMatchesByTeam(team: Team): Observable<Match[]> {
    return this.client.post<Match[]>(this.BASE_URL + this.LIST_BY_TEAM_EXT, team);
  }

  public updateMatch(updatedMatch: Match): Observable<boolean> {
    return this.client.put<boolean>(this.BASE_URL + this.UPDATE_EXT, updatedMatch);
  }

  public addMatch(newMatch: Match): Observable<Match> {
    return this.client.post<Match>(this.BASE_URL + this.ADD_EXT, newMatch);
  }
}
