import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {  } from '../../Service/restaurant.service';
import { EvaluationService } from '../../Service/evaluation.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-form-evaluation',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './form-evaluation.component.html',
  styleUrl: './form-evaluation.component.css'
})
export class FormEvaluationComponent {

  constructor(private evaluationService  : EvaluationService)
  {}

  public restaurant_id : number = 1
  public nom : string = ""
  public texte : string = ""
  public note : number = 0
  public date_creation : string = ""
  public date_MAJ : string = ""

  addLivre(form: NgForm) : void{
      if(form.valid)
      {
        this.evaluationService.addEvaluation(this.restaurant_id, this.nom, this.texte, this.note, this.date_creation, this.date_MAJ).subscribe()
      }
  }

}
