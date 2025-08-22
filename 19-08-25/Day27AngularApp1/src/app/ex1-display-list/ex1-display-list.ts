import { Component } from '@angular/core';

@Component({
  selector: 'app-ex1-display-list',
  imports: [],
  templateUrl: './ex1-display-list.html',
  styleUrl: './ex1-display-list.css',
})
export class Ex1DisplayList {
  fruits = [
  {
    title: 'Strawberry',
    description: 'A sweet red fruit rich in vitamin C and antioxidants.',
    image: 'https://upload.wikimedia.org/wikipedia/commons/2/29/PerfectStrawberry.jpg'
  },
  {
    title: 'Mango',
    description: 'A tropical fruit known as the king of fruits, juicy and delicious.',
    image: 'https://upload.wikimedia.org/wikipedia/commons/9/90/Hapus_Mango.jpg'
  },
  {
    title: 'Avocado',
    description: 'A creamy fruit rich in healthy fats, fiber, and vitamins.',
     image: 'https://commons.wikimedia.org/wiki/File:Avocado_Hass_-_single_and_halved.jpg#/media/File:Avocado_Hass_-_single_and_halved.jpg'
  },
  {
    title: 'Banana',
    description: 'A soft and sweet fruit, high in potassium and energy.',
    image: 'https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg'
  },
  {
    title: 'Dragonfruit',
    description: 'An exotic fruit with a unique look, mildly sweet and full of fiber.',
    image: 'assets/images/dragonfruit.jpg'
  },
  {
    title: 'Apple',
    description: 'A crunchy fruit that keeps you healthy and refreshed.',
    image: 'https://upload.wikimedia.org/wikipedia/commons/1/15/Red_Apple.jpg'
  }
];
}