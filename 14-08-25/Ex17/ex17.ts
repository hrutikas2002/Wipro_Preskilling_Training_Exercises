// Ex17: Create a TypeScript class Calculator with methods add(a: number, b: number): number and subtract(a: number, b: number): number.

class calculator{
    add(a:number,b:number):number{
        return a+b;
    }

    subtract(a:number,b:number):number{
        return a-b;
    }
}

let c1 = new calculator();
console.log("Addition: "+c1.add(15,85));
console.log("Subtraction: "+c1.subtract(85,5));