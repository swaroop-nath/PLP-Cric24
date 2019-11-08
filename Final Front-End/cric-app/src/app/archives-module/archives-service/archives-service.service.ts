import { Injectable } from '@angular/core';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { Observable } from 'rxjs';
import { Match } from 'src/app/model/match.model';
import { Team } from 'src/app/model/team.model';
import { TeamsService } from 'src/app/teams-module/teams-service/teams-service.service';
import { Stadium } from 'src/app/model/stadium.model';
import { StadiumsService } from 'src/app/stadiums-module/stadiums-service/stadiums-service.service';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';

@Injectable({
  providedIn: 'root'
})
export class ArchivesService {

  matches_master: Match[];

  private BASE_URL = 'http://localhost:7170/archives-api';
  private LIST_ALL_EXT = '/list-matches';
  private LIST_BY_TEAM_EXT = '/list-matches/by-team';
  private UPDATE_EXT = '/update-match';
  private ADD_EXT = '/add-match';
  
  transitMatch: Match;

  constructor(private cricService: CricketService, private teamsService: TeamsService, private stadiumsService: StadiumsService) { 
    this.matches_master = [];
  }

  public saveFetchedMatches(matches: Match[]){
    this.matches_master = matches;
    this.matches_master.forEach(match => match.matchSchedule = new Date(match.matchSchedule))
  }

  public fetchAllMatches(): Observable<Match[]> {
    return this.cricService.fetchAll<Match>(this.BASE_URL + this.LIST_ALL_EXT);
  }

  public fetchMatchesByTeam(team: Team): Observable<Match[]> {
    return this.cricService.fetchEntityByDependentEntity<Match[], Team>(this.BASE_URL + this.LIST_BY_TEAM_EXT, team);
  }

  public persistMatchDetails(match: Match): Observable<Match> {
    return this.cricService.persistEntityForEntity<Match, Match>(this.BASE_URL + this.ADD_EXT, match);
  }

  public updateMatchDetails(match: Match): Observable<boolean> {
    return this.cricService.updateEntityForEntity<boolean, Match>(this.BASE_URL + this.UPDATE_EXT, match);
  }

  public fetchAllTeams(): Observable<Team[]> {
    return this.teamsService.fetchAllTeams();
  }

  public fetchAllStadiums(): Observable<Stadium[]> {
    return this.stadiumsService.listStadium();
  }

  getParentRoute() {
    return this.cricService.parentRoute;
  }

  getFromBackStack() {
    return this.cricService.componentBackStack.pop();
  }

  addToBackStack(component: BackStack) {
    return this.cricService.componentBackStack.push(component)
  }
  
  getUser(): string {
    return this.authService.isUserLoggedIn();
  }
}
