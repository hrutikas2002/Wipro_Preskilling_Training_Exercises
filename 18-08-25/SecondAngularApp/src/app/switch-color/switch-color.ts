import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-switch-color',
  imports: [FormsModule],
  templateUrl: './switch-color.html',
  styleUrl: './switch-color.css'
})
export class SwitchColor {
  colors: string[] = ['red', 'blue', 'green', 'orange', 'purple'];
  selectedColor: string = '';  
}
