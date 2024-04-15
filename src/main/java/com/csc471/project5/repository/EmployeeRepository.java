package com.csc471.project5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.csc471.project5.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, String> {
	
	Optional<Employee> findEmployeeBySsn(String ssn);

}
