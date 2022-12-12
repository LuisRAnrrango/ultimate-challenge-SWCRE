import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  private personasUrl = 'http://localhost:8013/personas/';

  constructor(private http: HttpClient) {}

  public getAllPersonas(): Observable<any> {
    return this.http.get(this.personasUrl);
  }

  public savePersona(persona: any): Observable<any> {
    return this.http.post(this.personasUrl, persona);
  }

  public deletePersonabyId(idPersona: any): Observable<any> {
    return this.http.delete(this.personasUrl + 'delete/' + idPersona);
  }
}
