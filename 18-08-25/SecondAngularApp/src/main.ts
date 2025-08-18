import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { List } from './app/list/list';
import { IfDirective } from './app/if-directive/if-directive';
import { Countrylist } from './app/countrylist/countrylist';
import { SwitchColor } from './app/switch-color/switch-color';
import { SearchFilter } from './app/search-filter/search-filter';
import { Ex15Home } from './app/ex15-home/ex15-home';

// Exercise 9
// bootstrapApplication(App, appConfig)
//   .catch((err) => console.error(err));

//Exercise 10
// bootstrapApplication(List, appConfig)
//   .catch((err) => console.error(err));


//Exercise 11
// bootstrapApplication(IfDirective, appConfig)
//   .catch((err) => console.error(err));


//Exercise 12
// bootstrapApplication(Countrylist, appConfig)
//   .catch((err) => console.error(err));

//Exercise 13
// bootstrapApplication(SwitchColor, appConfig)
//   .catch((err) => console.error(err));

  //Exercise 14
// bootstrapApplication(SearchFilter, appConfig)
//   .catch((err) => console.error(err));


  //Exercise 15
bootstrapApplication(Ex15Home, appConfig)
  .catch((err) => console.error(err));
