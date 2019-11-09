import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { BackStack } from 'src/app/cricket-service/back-stack.interface'
import { AfterBadRoute } from './after-bad-route.interface';

@Injectable({
  providedIn: 'root'
})
export class CricketService {
  parentRoute: any;

  componentBackStack: BackStack[];

  homeComponents: AfterBadRoute[];

  constructor(private client: HttpClient) { 
    this.componentBackStack = [];
    this.homeComponents = [];
  }

  fetchAll<T>(fetchUrl: string): Observable<T[]> {
    return this.client.get<T[]>(fetchUrl);
  }

  fetchEntityByDependentEntity<U, V>(fetchUrl: string, dependentEntity: V): Observable<U> {
    return this.client.post<U>(fetchUrl, dependentEntity);
  }

  fetchEntityForCondition<U>(fetchUrl: string): Observable<U> {
    return this.client.get<U>(fetchUrl);
  }

  persistEntityForEntity<U, V>(persistUrl: string, entity: V): Observable<U> {
    return this.client.post<U>(persistUrl, entity);
  }

  updateEntityForEntity<U, V>(updateUrl: string, entity: V): Observable<U> {
    return this.client.put<U>(updateUrl, entity);
  }

  deleteEntityForEntity<U>(deleteUrl: string): Observable<U> {
    return this.client.delete<U>(deleteUrl);
  }

}
