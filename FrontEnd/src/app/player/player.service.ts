import { Injectable } from '@angular/core';
import { Player } from '../model/player';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(public http:HttpClient) { }

  savePlayer(pl : Player){
    return this.http.post<number>("http://localhost:8889/player/add",pl);
  }

  findPlayerById(id:number):Observable<Player>{
   return this.http.get<Player>("http://localhost:8889/player/id/" + id); 
  }

  findPlayerByName(name:string):Observable<Player[]>{
    return this.http.get<Player[]>("http://localhost:8889/player/name/" + name); 
   }

  deletePlayer(id: number){
    this.http.delete<boolean>("http://localhost:8889/player/delete/" + id).subscribe()
  }

  listPlayer(): Observable<any>{
    return this.http.get("http://localhost:8889/player/all");
  }

  updatePlayer(play:Player){
    return this.http.put<Player>("http://localhost:8889/player/update",play);
  }
}
