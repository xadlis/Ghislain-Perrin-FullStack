import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import {Observable, map} from 'rxjs'
import { RestaurantService} from '../../Service/restaurant.service';
import { Restaurant } from '../../Interface/restaurant';
import { ColorRestaurantDirective } from '../../Directive/color-restaurant.directive';

@Component({
  selector: 'app-restaurant',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive, RouterOutlet, ColorRestaurantDirective],
  templateUrl: './restaurant.component.html',
  styleUrl: './restaurant.component.css'
})
export class RestaurantComponent {

  public listeRestaurants : Restaurant[] = []

  constructor(private restaurantService : RestaurantService){}

  ngOnInit() : void{
    this.refreshRestaurant()
  }

  public refreshRestaurant()
  {
    this.restaurantService.getRestaurants().subscribe(value =>{
      this.listeRestaurants = value;
      this.listeRestaurants.forEach((restaurant) =>{
        this.restaurantService.getCover(restaurant.id).subscribe((coverUrl) =>{
          restaurant.coverUrl = coverUrl
        })
        this.restaurantService.getEvaluation(restaurant.id).subscribe((evaluation) =>{
          restaurant.evaluations = evaluation
        })
      })
    })
  }
}
