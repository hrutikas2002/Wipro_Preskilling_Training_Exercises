import { UpperCasePipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ex1-pipe',
  imports: [FormsModule, UpperCasePipe ],
  templateUrl: './ex1-pipe.html',
  styleUrl: './ex1-pipe.css',
})
export class Ex1Pipe {
  text: string = '';
}
