import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Workexp } from '../model/workexp';

@Injectable({
  providedIn: 'root'
})
export class WorkexpService {
  expURL = 'https://backendproyectoap.herokuapp.com/workexp/'
  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Workexp[]>{
    return this.httpClient.get<Workexp[]>(this.expURL + 'list');
  }

  public detail (id:number): Observable<Workexp>{
    return this.httpClient.get<Workexp>(this.expURL + `detail/${id}`);
  }
  public save(experience: Workexp): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create', experience);
  }

  public update(id: number, experience: Workexp): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, experience);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }
}
