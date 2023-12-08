import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Restaurant } from '../Interface/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private httpClient : HttpClient) { }

  getRestaurants() : Observable<Restaurant[]>{
    return this.httpClient.get<Restaurant[]>('http://localhost:8080/restaurants')
  }

  getRestaurantById(restaurant_id : number) : Observable<Restaurant>{
    return this.httpClient.get<Restaurant>(`http://localhost:8080/restaurants?id=${restaurant_id}`,)
  }

  addRestaurants(nom : string, adresse : string)
  {
    return this.httpClient.post('http://localhost:8080/restaurant',{"nom" : nom, "adresse" : adresse})
  }

  getCover(id : number) : Observable<string>{
    return this.httpClient.get<string>(`http://localhost:8080/restaurant/${id}/cover`,{responseType: 'text' as 'json'});
  }

  getEvaluation(id : number) : Observable<string>{
    return this.httpClient.get<string>(`http://localhost:8080/restaurant/${id}/evaluation`,{responseType: 'text' as 'json'});
  }
}
