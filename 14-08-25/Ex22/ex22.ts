// Ex22:Create a generic class Stack<T> with methods push(item: T): void, pop(): T | undefined, and peek(): T | undefined. The class should represent a stack data structure for elements of type T.

class Stack<T> {
  private items: T[] = [];

  push(item: T): void {
    this.items.push(item);
  }

  pop(): T | undefined {
    return this.items.pop();
  }

  peek(): T | undefined {
    return this.items[this.items.length - 1];
  }
}

let stack1 = new Stack<number>();
stack1.push(10);
stack1.push(20);
stack1.push(30);

console.log(stack1.peek());
console.log(stack1.pop());
console.log(stack1.peek());

let stringStack = new Stack<string>();
stringStack.push("Rutika");
stringStack.push("Vedant");
console.log(stringStack.peek());
