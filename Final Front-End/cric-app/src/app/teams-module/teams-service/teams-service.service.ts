import { Injectable } from '@angular/core';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { Team } from 'src/app/model/team.model';
import { Observable } from 'rxjs';
import { PlayersService } from 'src/app/players-module/players-service/players-service.service';
import { Player } from 'src/app/model/player.model';

@Injectable({
  providedIn: 'root'
})
export class TeamsService {

  private BASE_URL = "http://localhost:8888/team";
  private LIST_ALL_EXT = '/all';
  private ADD_EXT = '/add';
  private FETCH_BY_ID_EXT = '/id/';
  private FETCH_BY_NAME_EXT = '/name/';
  private UPDATE_EXT = '/update';
  private DELETE_EXT = '/delete/';

  constructor(private cricService: CricketService) { }

  public fetchAllTeams(): Observable<Team[]> {
    return this.cricService.fetchAll<Team>(this.BASE_URL + this.LIST_ALL_EXT);
  }
  
  saveTeam(tl: Team): Observable<Team> {
    return this.cricService.persistEntityForEntity<Team, Team>(this.BASE_URL + this.ADD_EXT, tl);
  }

  findTeamById(id: number): Observable<Team> {
    return this.cricService.fetchEntityForCondition<Team>(this.BASE_URL + this.FETCH_BY_ID_EXT + id);
  }

  findTeamByName(name: string): Observable<Team[]> {
    return this.cricService.fetchEntityForCondition<Team[]>(this.BASE_URL = this.FETCH_BY_NAME_EXT + name);
  }

  updateTeam(t1: Team): Observable<Team> {
    return this.cricService.updateEntityForEntity<Team, Team>(this.BASE_URL + this.UPDATE_EXT, t1);
  }

  deleteTeam(id: number): Observable<boolean> {
    return this.cricService.deleteEntityForEntity<boolean>(this.BASE_URL + this.DELETE_EXT + id);
  }

  fetchAllPlayers(): Observable<Player[]> {
    return this.cricService.fetchAll<Player>('http://localhost:8889/player/all')
  }

}
