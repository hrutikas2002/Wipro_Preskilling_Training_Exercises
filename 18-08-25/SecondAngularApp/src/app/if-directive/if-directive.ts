import { Component } from '@angular/core';

@Component({
  selector: 'app-if-directive',
  imports: [],
  templateUrl: './if-directive.html',
  styleUrl: './if-directive.css'
})
export class IfDirective {
  
  showMessage:boolean=false;

  toggleMessage(){
    this.showMessage=!this.showMessage;
  }
}
