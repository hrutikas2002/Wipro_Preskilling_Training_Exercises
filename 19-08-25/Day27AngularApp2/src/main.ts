import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Ex8Home } from './app/ex8-home/ex8-home';

bootstrapApplication(Ex8Home, appConfig)
  .catch((err) => console.error(err));
