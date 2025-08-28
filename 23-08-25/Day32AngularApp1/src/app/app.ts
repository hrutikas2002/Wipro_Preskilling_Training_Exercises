import { CommonModule } from '@angular/common';
import { Component, OnInit, signal } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatStepperModule } from '@angular/material/stepper';
import { FormControlComp } from './form-control-comp/form-control-comp';
import { Ex4RegForm } from './ex4-reg-form/ex4-reg-form';

@Component({
  selector: 'app-root',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatListModule,
    MatStepperModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    FormControlComp,
    Ex4RegForm
  ],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App implements OnInit {
  title = 'City List';
  cities: string[] = ['Mumbai', 'Pune', 'Delhi', 'Bangalore', 'Nashik'];

  isLinear = false;
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;
  thirdFormGroup!: FormGroup;

  constructor(private _formBuilder: FormBuilder) {}

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required],
    });

    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', [Validators.required, Validators.min(1)]],
    });

    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: ['', [Validators.required, Validators.email]],
    });
  }

  onSubmit() {
    console.log('Name:', this.firstFormGroup.value.firstCtrl);
    console.log('Age:', this.secondFormGroup.value.secondCtrl);
    console.log('Email:', this.thirdFormGroup.value.thirdCtrl);
  }
}
