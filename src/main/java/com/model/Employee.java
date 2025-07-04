package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dept")
	private String dept;
	
	@Column(name="salary")
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, String dept,int salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary=salary;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int  salary) {
		this.salary=salary;
	}
	
	@Override
	public String toString() {
		
		return "Id: "+id+" Name: "+name+" Department: "+dept+" Salary: "+salary;
	}
}
