import { Injectable } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StadiumdetailsService {

  stadiums: StadiumModel[] = [];

  constructor(public http: HttpClient) { }

  saveStadium(stad : StadiumModel){
    return this.http.post<StadiumModel>("http://localhost:8890/stadium/add", stad);
  }
  
  listStadium():Observable<StadiumModel[]>{
    return this.http.get<StadiumModel[]>("http://localhost:8890/stadium/all");
  }

  listByCountry(country:string):Observable<StadiumModel[]>{
    return this.http.get<StadiumModel[]>("http://localhost:8890/stadium/country/" + country);
  }

  listByName(name:string):Observable<StadiumModel[]>{
    return this.http.get<StadiumModel[]>("http://localhost:8890/stadium/name/" + name);
  }

  findStadiumById(id:number):Observable<StadiumModel>{
    return this.http.get<StadiumModel>("http://localhost:8890/stadium/id/" + id);
  }

  updateStadium(stad : StadiumModel){
    return this.http.put<StadiumModel>("http://localhost:8890/stadium/update", stad);
  }

  deleteStadium(id:number):Observable<boolean>{
    return this.http.delete<boolean>("http://localhost:8890/stadium/delete/" + id);
  }
}
