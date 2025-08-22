import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Vehiclecomp } from './app/vehiclecomp/vehiclecomp';

bootstrapApplication(Vehiclecomp, appConfig)
  .catch((err) => console.error(err));
