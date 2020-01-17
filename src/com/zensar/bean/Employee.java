package com.zensar.bean;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private String profile;
	
	
	public Employee(int employeeId, String employeeName, String profile) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.profile = profile;
	}
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", profile=" + profile + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
