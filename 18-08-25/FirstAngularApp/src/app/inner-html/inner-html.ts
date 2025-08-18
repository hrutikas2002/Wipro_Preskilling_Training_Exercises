import { Component } from '@angular/core';

@Component({
  selector: 'app-inner-html',
  imports: [],
  template: `<div class="container text-center mt-5">
    <h2 class="text-primary">This is InnerHTML Component</h2>
    <p>
      This is rendered using the <b>template</b> property instead of
      templateUrl.
    </p>
  </div>`,
  styleUrl: './inner-html.css',
})
export class InnerHtml {}
