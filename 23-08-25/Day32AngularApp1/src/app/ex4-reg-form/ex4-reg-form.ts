import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-ex4-reg-form',
  imports: [ReactiveFormsModule, MatInputModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatButtonModule ],
  templateUrl: './ex4-reg-form.html',
  styleUrl: './ex4-reg-form.css',
  standalone:true
})
export class Ex4RegForm {
  fg: FormGroup;
 
  subjects: string[] = ['Core Java', 'Advance Java', 'Springboot', 'Angular','Microservices'];

  constructor(private fb: FormBuilder) {
    this.fg = this.fb.group({
      name: ['',Validators.required],
      email: ['',[Validators.required,Validators.email]],
      dob: ['',[Validators.required]],
      subject: ['', Validators.required]
    });
  }
  onSubmit() {
      console.log("onSubmit")
      if(this.fg.valid)
      {
       console.log("form submitted");
      }
      else{
        console.log("Something went wrong")
      }
  }
}
