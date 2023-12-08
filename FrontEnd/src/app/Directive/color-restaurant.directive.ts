import { Directive, ElementRef, Renderer2, Input } from '@angular/core';

@Directive({
  selector: '[appColorRestaurant]',
  standalone: true
})
export class ColorRestaurantDirective {

  constructor(private el : ElementRef, private renderer : Renderer2)
  {}

  @Input("appColorRestaurant")
  set colorDirective(value: string)
  {
    if(parseInt(value) >= 2)
    {
      this.renderer.setStyle(this.el.nativeElement, 'color','yellow')
    }
    else
    {
      this.renderer.setStyle(this.el.nativeElement, 'color','red')
    }
  }

}
