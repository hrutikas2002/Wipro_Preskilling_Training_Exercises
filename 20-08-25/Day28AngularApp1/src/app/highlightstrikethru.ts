import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appHighlightstrikethru]'
})
export class Highlightstrikethru {

   constructor(private el: ElementRef, private renderer: Renderer2) {
    // set yellow text color
    this.renderer.setStyle(this.el.nativeElement, 'color', 'yellow');
    // apply strikethrough
    this.renderer.setStyle(this.el.nativeElement, 'text-decoration', 'line-through');
  }

}
