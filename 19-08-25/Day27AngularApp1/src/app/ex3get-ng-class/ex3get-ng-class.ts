import { NgClass } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-ex3get-ng-class',
  imports: [NgClass],
  templateUrl: './ex3get-ng-class.html',
  styleUrl: './ex3get-ng-class.css',
})
export class Ex3getNgClass {
  isRed = true;
  isGreen = false;

  getNgClass() {
    return {
      'bold-red': this.isRed,
      'italic': this.isGreen,
    };
  }
}
