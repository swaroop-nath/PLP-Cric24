import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CricketService {

  constructor(private client: HttpClient) { }

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

  deleteEntityForEntity<U, V>(deleteUrl: string, entity: V): Observable<U> {
    return this.client.delete<U>(deleteUrl, entity);
  }
}
