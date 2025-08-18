import 'bootstrap/dist/js/bootstrap.bundle.min.js';

import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Secondcomp } from './app/secondcomp/secondcomp';
import { Login } from './app/login/login';
import { InnerHtml } from './app/inner-html/inner-html';
//Exercise 1, 2
// bootstrapApplication(App, appConfig)
//   .catch((err) => console.error(err));

//Exercise 3
// bootstrapApplication(secondcomp, appConfig)
//   .catch((err) => console.error(err));

//Exercise 4 5
// bootstrapApplication(Login, appConfig)
//   .catch((err) => console.error(err));

//Exercise 6
bootstrapApplication(InnerHtml, appConfig)
  .catch((err) => console.error(err));
