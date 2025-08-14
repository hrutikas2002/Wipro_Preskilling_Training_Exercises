// Ex20:Write a generic TypeScript function pair<T, U>(first: T, second: U): [T, U] that takes two values of any types T and U, and returns them as a tuple.

// function pair<T, U>(first: T, second: U): [T, U] {
//     return [first, second];
// }


// let numAndString = pair<string, number>("Hello", 42);
// console.log(numAndString); 

// let boolAndArray = pair<boolean, number[]>(true, [1, 2, 3]);
// console.log(boolAndArray); 

class Pair<T, U> {
    first: T;
    second: U;

    constructor(first: T, second: U) {
        this.first = first;
        this.second = second;
    }

    getPair(): [T, U] {
        return [this.first, this.second];
    }
}

let p1 = new Pair<number, string>(101, "TypeScript");
console.log(p1.getPair()); 

let p2 = new Pair<boolean, number[]>(true, [1, 2, 3]);
console.log(p2.getPair()); 