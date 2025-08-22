import { Component } from '@angular/core';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-ex2ng-class',
  imports: [NgClass],
  templateUrl: './ex2ng-class.html',
  styleUrl: './ex2ng-class.css',
})
export class Ex2ngClass {
  isBoldRed = true;
  isItalic = false;
}
