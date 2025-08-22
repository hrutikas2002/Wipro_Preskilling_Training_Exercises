import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CtofPipe } from './ctof.pipe.';

@Component({
  selector: 'app-ex3-custompipe',
  imports: [FormsModule, CtofPipe],
  templateUrl: './ex3-custompipe.html',
  styleUrl: './ex3-custompipe.css'
})
export class Ex3Custompipe {
  tempC: number = 0;
}
