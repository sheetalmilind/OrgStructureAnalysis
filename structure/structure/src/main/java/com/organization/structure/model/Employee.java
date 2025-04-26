package com.organization.structure.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	public String id;
	public String firstName;
	public String lastName;
	public String managerId;
	public double salary;
	
	public List<Employee> subordinates = new ArrayList<>();

	public Employee(String id, String firstName, String lastName, double salary,String managerId
			) {
		//super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.managerId = managerId;
		this.salary = salary;
		
	}
	
	
	
	
}
