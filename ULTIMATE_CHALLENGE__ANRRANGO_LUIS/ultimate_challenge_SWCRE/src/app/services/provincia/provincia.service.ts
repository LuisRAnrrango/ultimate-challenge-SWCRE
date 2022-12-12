import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ProvinciaService {
  private API_SERVER = 'http://localhost:8012/provincias/';
  constructor(private httpClient: HttpClient) {}

  public getAlProvinciasByPais(idPais: any): Observable<any> {
    return this.httpClient.get(this.API_SERVER + idPais);
  }
}
