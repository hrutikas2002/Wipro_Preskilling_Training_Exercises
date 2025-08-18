import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Secondcomp } from './secondcomp/secondcomp';
import { Login } from './login/login';
import { InnerHtml } from './inner-html/inner-html';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Secondcomp,Login,InnerHtml],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('FirstAngularApp');
}
