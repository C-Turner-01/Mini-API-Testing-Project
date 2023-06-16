package com.apitest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataItem{

	@JsonProperty("profile_image")
	private String profileImage;

	@JsonProperty("employee_name")
	private String employeeName;

	@JsonProperty("employee_salary")
	private int employeeSalary;

	@JsonProperty("id")
	private int id;

	@JsonProperty("employee_age")
	private int employeeAge;

	public String getProfileImage(){
		return profileImage;
	}

	public String getEmployeeName(){
		return employeeName;
	}

	public int getEmployeeSalary(){
		return employeeSalary;
	}

	public int getId(){
		return id;
	}

	public int getEmployeeAge(){
		return employeeAge;
	}
}