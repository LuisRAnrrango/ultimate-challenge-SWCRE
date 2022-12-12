import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PaisService {
  private API_SERVER = 'http://localhost:8012/pais/';

  constructor(private httpClient: HttpClient) {}

  public getAllPaises(): Observable<any> {
    return this.httpClient.get(this.API_SERVER);
  }
}
