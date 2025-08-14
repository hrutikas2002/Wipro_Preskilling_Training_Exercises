// Ex16: Create an interface called Employee having empId, empName,salary . Create a list of employees and pass that to a function that takes a list of employee and print them and return the count of employees.
var empList = [
    {
        empId: 101,
        empName: "Rutika",
        salary: 50000
    },
    {
        empId: 102,
        empName: "Yash",
        salary: 85000
    },
    {
        empId: 103,
        empName: "Srushti",
        salary: 75000
    }
];
function printEmployees(employees) {
    for (var i = 0; i < employees.length; i++) {
        console.log(employees[i]);
    }
    return employees.length;
}
var count = printEmployees(empList);
console.log("Total Employees:", count);
