import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'colorans'
})
export class ColoransPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
