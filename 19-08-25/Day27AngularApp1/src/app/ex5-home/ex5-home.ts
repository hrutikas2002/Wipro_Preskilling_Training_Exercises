import { Component, Input } from '@angular/core';
import { Ex5Fruits } from '../ex5-fruits/ex5-fruits';
import { IFruit } from '../Ifruit';

@Component({
  selector: 'app-ex5-home',
  imports: [Ex5Fruits],
  templateUrl: './ex5-home.html',
  styleUrl: './ex5-home.css',
})
export class Ex5Home {
   fruits : IFruit[]= [
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
    title: 'Banana',
    description: 'A soft and sweet fruit, high in potassium and energy.',
    image: 'https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg'
  },
  {
    title: 'Apple',
    description: 'A crunchy fruit that keeps you healthy and refreshed.',
    image: 'https://upload.wikimedia.org/wikipedia/commons/1/15/Red_Apple.jpg'
  },
  {
      title: 'Orange',
      description: 'A citrus fruit full of vitamin C with a tangy taste.',
      image: 'https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg'
    },
    {
      title: 'Pineapple',
      description: 'A tropical fruit with a sweet and tangy flavor.',
      image: 'https://upload.wikimedia.org/wikipedia/commons/c/cb/Pineapple_and_cross_section.jpg'
    },
  ];

  // Function to remove fruit
  removeFruit(fruit: IFruit) {
    this.fruits = this.fruits.filter(f => f !== fruit);
    console.log(fruit.title+" is removed..")
  }

}
