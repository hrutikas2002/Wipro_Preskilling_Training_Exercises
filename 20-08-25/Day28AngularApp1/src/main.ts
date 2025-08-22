import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Ex1Pipe } from './app/ex1-pipe/ex1-pipe';
import { Ex2Datepipe } from './app/ex2-datepipe/ex2-datepipe';
import { Ex3Custompipe } from './app/ex3-custompipe/ex3-custompipe';
import { Ex4CustomeDirective } from './app/ex4-custome-directive/ex4-custome-directive';

// bootstrapApplication(Ex1Pipe, appConfig)
//   .catch((err) => console.error(err));

// bootstrapApplication(Ex2Datepipe, appConfig)
//   .catch((err) => console.error(err));

// bootstrapApplication(Ex3Custompipe, appConfig)
//   .catch((err) => console.error(err));

bootstrapApplication(Ex4CustomeDirective, appConfig)
  .catch((err) => console.error(err));