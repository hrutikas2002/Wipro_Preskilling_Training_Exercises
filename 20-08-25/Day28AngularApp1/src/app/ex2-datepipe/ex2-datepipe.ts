import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ex2-datepipe',
  imports: [DatePipe,FormsModule],
  templateUrl: './ex2-datepipe.html',
  styleUrl: './ex2-datepipe.css'
})
export class Ex2Datepipe {
  selectedDate: string = '';
}
