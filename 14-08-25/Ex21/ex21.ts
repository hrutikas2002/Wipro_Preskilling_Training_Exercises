// Ex21:Create a generic class Box<T> with a property value: T and a method getValue(): T that returns the value.

// Generic class
class Box<T> {
    value: T;

    constructor(value: T) {
        this.value = value;
    }

    getValue(): T {
        return this.value;
    }
}

// Example usage
let box1 = new Box<number>(123);
console.log(box1.getValue());

let box2 = new Box<string>("Rutika");
console.log(box2.getValue()); 

let box3 = new Box<boolean>(false);
console.log(box3.getValue()); 
