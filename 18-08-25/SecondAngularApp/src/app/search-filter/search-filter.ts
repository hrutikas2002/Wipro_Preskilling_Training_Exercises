import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-filter',
  imports: [FormsModule],
  templateUrl: './search-filter.html',
  styleUrl: './search-filter.css',
})
export class SearchFilter {
  names: string[] = ['Jayanta', 'Jayaram', 'Rutika', 'Rutu', 'Yash','Yashraj','Aditya','Adhira','Dipti','Dipak'];
  filteredNames: string[] = [...this.names];

  // called when user types
  onSearch(event: any) {
    const value = event.target.value.toLowerCase();
    this.filteredNames = this.names.filter((name) =>
      name.toLowerCase().startsWith(value)
    );
  }
}
