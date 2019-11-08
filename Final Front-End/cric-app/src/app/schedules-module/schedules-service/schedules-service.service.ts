import { Injectable } from '@angular/core';
import { Match } from 'src/app/model/match.model';
import { Team } from 'src/app/model/team.model';
import { Player } from 'src/app/model/player.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { AuthService } from 'src/app/auth-module/auth-service/auth-service.service';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';
import { AfterBadRoute } from 'src/app/cricket-service/after-bad-route.interface';

@Injectable({
  providedIn: 'root'
})
export class SchedulesService {
  match:Match;
  transitSchedule: Match;

  constructor(public httpClient: HttpClient, private cricService: CricketService, private authService: AuthService) { }

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

  getParentRoute() {
    return this.cricService.parentRoute;
  }

  getFromBackStack() {
    return this.cricService.componentBackStack.pop();
  }

  addToBackStack(component: BackStack) {
    return this.cricService.componentBackStack.push(component)
  }

  addToHomeStack(component: AfterBadRoute) {
    return this.cricService.homeComponents.push(component)
  }
  
  getUser(): string {
    return this.authService.isUserLoggedIn();
  }
}
