class Util {
    getDate() {
        const today = new Date();
        const dd = String(today.getDate()).padStart(2, '0');
        const mm = String(today.getMonth() + 1).padStart(2, '0'); // Months are 0-indexed
        const yyyy = today.getFullYear();
        return `${dd}-${mm}-${yyyy}`;
    }

    // b) Return value of PI
    getPI() {
        return Math.PI;
    }

    // c) Convert Centigrade to Fahrenheit
    convertC2F(celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // d) Get first n elements of Fibonacci series
    getFibonacci(n) {
        const fib = [];
        for (let i = 0; i < n; i++) {
            if (i === 0) fib.push(0);
            else if (i === 1) fib.push(1);
            else fib.push(fib[i - 1] + fib[i - 2]);
        }
        return fib;
    }
}

const util = new Util();

console.log(util.getDate());        
console.log(util.getPI());     
console.log(util.convertC2F(25));  
console.log(util.getFibonacci(5));