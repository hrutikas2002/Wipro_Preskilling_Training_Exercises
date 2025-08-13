function calculate(operation) {
    let n1 = parseFloat(document.getElementById("num1").value);
    let n2 = parseFloat(document.getElementById("num2").value);
    let result = "";

    if (isNaN(n1) || isNaN(n2)) {
        result = "Please enter valid numbers.";
    } else {
        switch (operation) {
            case 'add':
                result = n1 + n2;
                break;
            case 'sub':
                result = n1 - n2;
                break;
            case 'mul':
                result = n1 * n2;
                break;
            case 'div':
                if (n2 === 0) {
                    result = "Cannot divide by zero!";
                } else {
                    result = n1 / n2;
                }
                break;
        }
    }
    document.getElementById("result").textContent = "Result: " + result;
}