// Ex20:Write a generic TypeScript function pair<T, U>(first: T, second: U): [T, U] that takes two values of any types T and U, and returns them as a tuple.
// function pair<T, U>(first: T, second: U): [T, U] {
//     return [first, second];
// }
// let numAndString = pair<string, number>("Hello", 42);
// console.log(numAndString); 
// let boolAndArray = pair<boolean, number[]>(true, [1, 2, 3]);
// console.log(boolAndArray); 
var Pair = /** @class */ (function () {
    function Pair(first, second) {
        this.first = first;
        this.second = second;
    }
    Pair.prototype.getPair = function () {
        return [this.first, this.second];
    };
    return Pair;
}());
var p1 = new Pair(101, "TypeScript");
console.log(p1.getPair());
var p2 = new Pair(true, [1, 2, 3]);
console.log(p2.getPair());
