import { Routes } from '@angular/router';
import { HomeComponent } from './Component/home/home.component';
import { RestaurantComponent } from './Component/restaurant/restaurant.component';
import { RestaurantDetailComponent } from './Component/restaurant-detail/restaurant-detail.component';
import { FormEvaluationComponent } from './Component/form-evaluation/form-evaluation.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'restaurants', component: RestaurantComponent},
    {path: 'restaurant/:id', component: RestaurantDetailComponent},
    {path: 'restaurant/add', component: FormEvaluationComponent}
];
