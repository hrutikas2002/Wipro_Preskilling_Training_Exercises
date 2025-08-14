// Ex21:Create a generic class Box<T> with a property value: T and a method getValue(): T that returns the value.
// Generic class
var Box = /** @class */ (function () {
    function Box(value) {
        this.value = value;
    }
    Box.prototype.getValue = function () {
        return this.value;
    };
    return Box;
}());
// Example usage
var box1 = new Box(123);
console.log(box1.getValue());
var box2 = new Box("Hello");
console.log(box2.getValue());
var box3 = new Box(true);
console.log(box3.getValue());
