import { Component } from '@angular/core';
import { FormEvaluationComponent } from '../form-evaluation/form-evaluation.component';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import {Observable, map} from 'rxjs'
import { RestaurantService} from '../../Service/restaurant.service';
import { Restaurant } from '../../Interface/restaurant';
import { ColorRestaurantDirective } from '../../Directive/color-restaurant.directive';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-restaurant-detail',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive, RouterOutlet, ColorRestaurantDirective, FormEvaluationComponent],
  templateUrl: './restaurant-detail.component.html',
  styleUrl: './restaurant-detail.component.css'
})
export class RestaurantDetailComponent {

  constructor(private restaurantService : RestaurantService, private route: ActivatedRoute){}

  public restaurant? : Restaurant
  restaurant_indice : number = 1

  ngOnInit() : void{
    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id');
      if (idParam !== null) {
        this.restaurant_indice = +idParam;
      }
    })
    this.getRestaurant()
  }

  public getRestaurant()
  {
    this.restaurantService.getRestaurantById(Number(this.restaurant_indice)).subscribe(value =>{
      this.restaurant = value;
    })
  }
}
