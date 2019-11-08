import { Injectable } from '@angular/core';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { Observable } from 'rxjs';
import { Stadium } from 'src/app/model/stadium.model';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';
import { AuthService } from 'src/app/auth-module/auth-service/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class StadiumsService {

  private BASE_URL = 'http://localhost:8890/stadium';
  private LIST_ALL_EXT = '/all';
  private ADD_EXT = '/add';
  private BY_COUNTRY_EXT = '/country/';
  private BY_NAME_EXT = '/name/';
  private BY_ID_EXT = '/id/';
  private UPDATE_EXT = '/update';
  private DELETE_EXT = '/delete/';

  transitStadium: Stadium;

  constructor(private cricService: CricketService, private authService: AuthService) { }

  saveStadium(stad : Stadium){
    return this.cricService.persistEntityForEntity<Stadium, Stadium>(this.BASE_URL + this.ADD_EXT, stad);
  }
  
  listStadium():Observable<Stadium[]>{
    return this.cricService.fetchAll<Stadium>(this.BASE_URL + this.LIST_ALL_EXT);
  }

  listByCountry(country:string):Observable<Stadium[]>{
    return this.cricService.fetchEntityForCondition<Stadium[]>(this.BASE_URL + this.BY_COUNTRY_EXT + country);
  }

  listByName(name:string):Observable<Stadium[]>{
    return this.cricService.fetchEntityForCondition<Stadium[]>(this.BASE_URL + this.BY_NAME_EXT + name);
  }

  findStadiumById(id:number):Observable<Stadium>{
    return this.cricService.fetchEntityForCondition<Stadium>(this.BASE_URL + this.BY_ID_EXT + id);
  }

  updateStadium(stad : Stadium){
    return this.cricService.updateEntityForEntity<Stadium, Stadium>(this.BASE_URL + this.UPDATE_EXT, stad);
  }

  deleteStadium(id:number):Observable<boolean>{
    return this.cricService.deleteEntityForEntity<boolean>(this.BASE_URL + this.DELETE_EXT + id);
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
