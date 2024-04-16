package com.csc471.project5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csc471.project5.model.Dependent;
import com.csc471.project5.model.Employee;

public interface DependentRepository extends CrudRepository<Dependent, String> {
	
	List<Dependent> findDependentsByEmployee(Employee employee);
	
	Optional<Dependent> findById(int id);
	
}
