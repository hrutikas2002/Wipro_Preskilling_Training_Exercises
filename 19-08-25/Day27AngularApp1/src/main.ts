import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Ex1home } from './app/ex1home/ex1home';
import { Ex2ngClass } from './app/ex2ng-class/ex2ng-class';
import { Ex3getNgClass } from './app/ex3get-ng-class/ex3get-ng-class';
import { Ex4NgStyle } from './app/ex4-ng-style/ex4-ng-style';
import { Ex5Home } from './app/ex5-home/ex5-home';

// bootstrapApplication(App, appConfig)
//   .catch((err) => console.error(err));

// //Exercise 1
// bootstrapApplication(Ex1home, appConfig)
//   .catch((err) => console.error(err));

// //Exercise 2
// bootstrapApplication(Ex2ngClass, appConfig)
//   .catch((err) => console.error(err));

// //Exercise 3
// bootstrapApplication(Ex3getNgClass, appConfig)
//   .catch((err) => console.error(err));

//Exercise 4
// bootstrapApplication(Ex4NgStyle, appConfig)
//   .catch((err) => console.error(err));

//Exercise 4
bootstrapApplication(Ex5Home, appConfig)
.catch((err) => console.error(err));
