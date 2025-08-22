import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IFruit } from '../Ifruit';

@Component({
  selector: 'app-ex5-fruits',
  imports: [],
  templateUrl: './ex5-fruits.html',
  styleUrl: './ex5-fruits.css',
})
export class Ex5Fruits {
  // @Input() title!: string;
  // @Input() description!: string;
  // @Input() image!: string;

  @Input() fruit!: IFruit; 

  // Create an event emitter
  @Output() remove = new EventEmitter<IFruit>();

  // Function when button clicked
  onRemove() {
    this.remove.emit(this.fruit);  // Emit fruit object back to parent
  }
}
