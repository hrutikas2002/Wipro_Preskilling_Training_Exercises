import { Component } from '@angular/core';

@Component({
  selector: 'app-countrylist',
  imports: [],
  templateUrl: './countrylist.html',
  styleUrl: './countrylist.css'
})
export class Countrylist {
  countries = ["India",'USA', 'Canada', 'Germany', 'Japan', 'Australia']

//strart empty list
   loadedCountries: string[] = [];

  // 3) On click: copy into the dropdown list
  ShowContries() {
    this.loadedCountries = [...this.countries];
  }
}
