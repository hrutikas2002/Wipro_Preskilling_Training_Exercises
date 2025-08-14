// Ex22:Create a generic class Stack<T> with methods push(item: T): void, pop(): T | undefined, and peek(): T | undefined. The class should represent a stack data structure for elements of type T.
var Stack = /** @class */ (function () {
    function Stack() {
        this.items = [];
    }
    Stack.prototype.push = function (item) {
        this.items.push(item);
    };
    Stack.prototype.pop = function () {
        return this.items.pop();
    };
    Stack.prototype.peek = function () {
        return this.items[this.items.length - 1];
    };
    return Stack;
}());
var stack1 = new Stack();
stack1.push(10);
stack1.push(20);
stack1.push(30);
console.log(stack1.peek());
console.log(stack1.pop());
console.log(stack1.peek());
var stringStack = new Stack();
stringStack.push("Rutika");
stringStack.push("Vedant");
console.log(stringStack.peek());
