import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms'; 

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('SecondAngularApp');
  //Exercise 7
  // message: string = 'Hello, Welcome to Angular World!';

  //Exercise 8
  message="";


  //Exercise 9
  showMessage(){
    console.log(this.message);
  }
}
