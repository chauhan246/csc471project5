package com.csc471.project5.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	@Id
	@NotNull
	@Size(min=9, max = 9, message = "Social Security Number (ssn) must be exeactly 9 characters")
	private String ssn;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Integer salary;
	@Column(nullable = true)
	private Character middleInitial;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	private String address;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Dependent> dependents;

	public Employee() {
	}

	public Employee(
			@NotNull @Size(min = 9, max = 9, message = "Social Security Number (ssn) must be exeactly 9 characters") String ssn,
			@NotNull String firstName, @NotNull String lastName, @NotNull Integer salary, Character middleInitial,
			LocalDate dob, String address, List<Dependent> dependents) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.middleInitial = middleInitial;
		this.dob = dob;
		this.address = address;
		this.dependents = dependents;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Character getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(Character middleInitial) {
		this.middleInitial = middleInitial;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}
	
	@Override
	public String toString() {
		return "SSN: " + this.ssn + ", Name: " + this.firstName + " " + this.middleInitial + " " + this.lastName + ", " + 
	           "DOB: " + this.dob + ", Salary: " + this.salary + ", Address: " + this.address;
	}
}
