import { Injectable } from '@angular/core';
import { Team } from '../model/team';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(public http: HttpClient) { }

  saveTeam(tl: Team) {
    return this.http.post<Team>("http://localhost:8890/team/add", tl);
  }

  findTeamById(id: number): Observable<Team> {
    return this.http.get<Team>("http://localhost:8890/team/id/" + id);
  }
  findTeamByName(name: string): Observable<Team> {
    return this.http.get<Team>("http://localhost:8890/team/name/" + name);
  }
  listAll(): Observable<any> {
    return this.http.get("http://localhost:8890/team/all");
  }
  updateTeam(t1: Team) {
    return this.http.put<Team>("http://localhost:8890/team/update", t1);
  }

  deleteTeam(id: number) {
    return this.http.delete<boolean>("http://localhost:8888/team/delete/" + id).subscribe();
  }

}


