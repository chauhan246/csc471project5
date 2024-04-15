package com.csc471.project5.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
public class Dependent {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@Column(nullable = true)
	private Character middleInitial;
	private String relationship;
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "employee_ssn", referencedColumnName = "ssn")
	private Employee employee;
	
	public Dependent() {
	}

	public Dependent(int id, @NotNull String firstName, @NotNull String lastName, Character middleInitial,
			String relationship, Employee employee) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.relationship = relationship;
		this.employee = employee;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Character getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(Character middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + ", Name: " + this.firstName + " " + this.middleInitial + " " + this.lastName + ", " + 
		       "SSN: " + this.employee.getSsn() + ", Relationship: " + this.relationship;
	}
}
