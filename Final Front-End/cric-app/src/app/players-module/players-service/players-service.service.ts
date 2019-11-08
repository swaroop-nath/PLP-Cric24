import { Injectable } from '@angular/core';
import { Player } from 'src/app/model/player.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { TeamsService } from 'src/app/teams-module/teams-service/teams-service.service';
import { Team } from 'src/app/model/team.model';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';
import { AuthService } from 'src/app/auth-module/auth-service/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class PlayersService {

  transitPlayer: Player;

  private BASE_URL = 'http://localhost:8889/player';
  private ADD_EXT = '/add';
  private FETCH_ALL_EXT = '/all';
  private FETCH_BY_ID_EXT = '/id/';
  private FETCH_BY_NAME_EXT = '/name/';
  private UDPATE_EXT = '/update';
  private DELETE_EXT = '/delete/';

  constructor(private cricService: CricketService, private teamsService: TeamsService, private authService: AuthService) { }

  savePlayer(player : Player){
    return this.cricService.persistEntityForEntity<Player, Player>(this.BASE_URL + this.ADD_EXT, player);
  }

  findPlayerById(id: number): Observable<Player>{
   return this.cricService.fetchEntityForCondition<Player>(this.BASE_URL + this.FETCH_BY_ID_EXT + id); 
  }

  findPlayerByName(name: string): Observable<Player[]>{
    return this.cricService.fetchEntityForCondition<Player[]>(this.BASE_URL + this.FETCH_BY_NAME_EXT + name); 
   }

  deletePlayer(id: number): Observable<boolean>{
    return this.cricService.deleteEntityForEntity<boolean>(this.BASE_URL + this.DELETE_EXT + id);
  }

  listPlayer(): Observable<Player[]>{
    return this.cricService.fetchAll<Player>(this.BASE_URL + this.FETCH_ALL_EXT);
  }

  updatePlayer(play:Player): Observable<Player>{
    return this.cricService.updateEntityForEntity<Player, Player>(this.BASE_URL + this.UDPATE_EXT, play);
  }

  public fetchAllTeams(): Observable<Team[]> {
    return this.teamsService.fetchAllTeams();
  }

  getFromBackStack() {
    return this.cricService.componentBackStack.pop();
  }

  addToBackStack(component: BackStack) {
    return this.cricService.componentBackStack.push(component)
  }

  getParentRoute() {
    return this.cricService.parentRoute;
  }

  getUser(): string {
    return this.authService.isUserLoggedIn();
  }
}
