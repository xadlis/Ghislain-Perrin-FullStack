import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EvaluationService {

  constructor(private httpClient : HttpClient){}


  addEvaluation(restaurant_id : number, nom : string, texte : string, note : number, date_creation : string, date_MAJ : string)
  {
    return this.httpClient.post(`http://localhost:8080/restaurant/${restaurant_id}/evaluation`, {"nom" : nom, "texte" : texte, "note" : note, "date_création" : date_creation, "date_MAJ" : date_MAJ})
  }

}
