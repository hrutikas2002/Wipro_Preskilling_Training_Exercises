// Ex17: Create a TypeScript class Calculator with methods add(a: number, b: number): number and subtract(a: number, b: number): number.
var calculator = /** @class */ (function () {
    function calculator() {
    }
    calculator.prototype.add = function (a, b) {
        return a + b;
    };
    calculator.prototype.subtract = function (a, b) {
        return a - b;
    };
    return calculator;
}());
var c1 = new calculator();
console.log("Addition: " + c1.add(15, 85));
console.log("Subtraction" + c1.subtract(85, 5));
