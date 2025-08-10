package com.wipro.collection;

public class Employee implements Comparable<Employee>{
	String empId;
	String empName;
	int empAge;
	double salary;
	public Employee(String empId, String empName, int empAge, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", salary=" + salary + "]";
	}
	
	@Override
    public int compareTo(Employee o) {
		return Double.compare(o.salary,this.salary);
    }
}
