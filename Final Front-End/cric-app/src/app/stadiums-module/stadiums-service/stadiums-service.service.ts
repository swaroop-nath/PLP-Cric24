import { Injectable } from '@angular/core';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { Observable } from 'rxjs';
import { Stadium } from 'src/app/model/stadium.model';

@Injectable({
  providedIn: 'root'
})
export class StadiumsService {

  private BASE_URL = 'http://localhost:8890/stadium';
  private LIST_ALL_EXT = '/all';

  constructor(private cricService: CricketService) { }

  public fetchAllStadiums(): Observable<Stadium[]> {
    return this.cricService.fetchAll<Stadium>(this.BASE_URL + this.LIST_ALL_EXT);
  }
}
