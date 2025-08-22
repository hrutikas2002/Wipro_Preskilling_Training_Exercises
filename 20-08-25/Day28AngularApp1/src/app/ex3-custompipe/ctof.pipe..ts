import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ctof'
})
export class CtofPipe implements PipeTransform {
  transform(value: number): string {
    if (value == null) return '';   // handle empty input
    const fahrenheit = (value * 9/5) + 32;
    return `${fahrenheit}F`;
  }
}
