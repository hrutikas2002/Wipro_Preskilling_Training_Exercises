import { Component } from '@angular/core';
import { Highlightstrikethru } from '../highlightstrikethru';

@Component({
  selector: 'app-ex4-custome-directive',
  imports: [Highlightstrikethru],
   standalone: true,
  templateUrl: './ex4-custome-directive.html',
  styleUrl: './ex4-custome-directive.css'
})
export class Ex4CustomeDirective {

}
