package com.csc471.project5.service;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc471.project5.model.Employee;
import com.csc471.project5.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmps(){
		List<Employee> listOfEmps = new ArrayList<>();
		Iterable<Employee> listOfEmployees = employeeRepository.findAll();
		
		if(listOfEmployees == null) {
			return null;
		}
		for(Employee emp : listOfEmployees) {
			listOfEmps.add(emp);
		}
		return listOfEmps;
	}
	
	public void addNewEmp(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Employee getEmployee(String ssn) throws AccountNotFoundException {
		Employee employee = employeeRepository.findEmployeeBySsn(ssn).orElseThrow(() -> 
			new AccountNotFoundException("SSN: " + ssn + " not found"));
		
		return employee;
	}
	
	public void updateEmp(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteEmp(String ssn) {
		employeeRepository.deleteById(ssn);
	}
}
