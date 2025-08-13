var a = 5;      // global variable
const b = 10;   // global constant

function exampleScope() {
  a = 20;       // updates global variable a
  let c = 15;   // function/block scoped variable

  console.log("Inside function:");
  console.log("a:", a); // 20
  console.log("c:", c); // 15

  if (true) {
    let b = 30;  // block scoped, shadows global const b
    console.log("Inside if block:");
    b = a+b;   //a is accessible cause it is global variable 20+30= 50
    console.log("b:", b); // 30
    console.log("c inside if block:", c); // 15 (accessible here)
  }

  console.log("Outside if block but inside function:");
  console.log("b:", b); // 10 (global const)
}

exampleScope();

console.log("Outside function:");
console.log("a:", a); // 20 (updated global var)
console.log("b:", b); // 10 (global const)
// console.log("c:", c); // Error! c is block scoped inside function
