package com.wipro.springcontext.SpringDepartment.beans;

public class Department {
	private String deptCode;
    private String departmentName;
    
    
	public Department() {
		super();
	}
	public Department(String deptCode, String departmentName) {
		super();
		this.deptCode = deptCode;
		this.departmentName = departmentName;
	}


	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [deptCode=" + deptCode + ", departmentName=" + departmentName + "]";
	}
    
    
}
