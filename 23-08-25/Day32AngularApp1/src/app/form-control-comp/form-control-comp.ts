import { Component } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-control-comp',
  imports: [ReactiveFormsModule],
  templateUrl: './form-control-comp.html',
  styleUrl: './form-control-comp.css'
})
export class FormControlComp {
  text = new FormControl();
  revText = '';

  constructor(){
    this.text.valueChanges.subscribe(value=>{
      this.revText = value ? value.split('').reverse().join('') : '';
    })
  }
}
