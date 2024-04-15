package com.csc471.project5.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc471.project5.model.Dependent;
import com.csc471.project5.model.Employee;
import com.csc471.project5.repository.DependentRepository;

@Service
public class DependentService {
	@Autowired
	DependentRepository dependentRepository;
	
	public void addNewDep(Dependent dependent) {
		dependentRepository.save(dependent);
	}
	
	public List<Dependent> getAllDep(Employee employee) {
		return dependentRepository.findDependentsByEmployee(employee);
	}
	
	public Dependent getDep(int id) throws AccountNotFoundException {
		Dependent dependent = dependentRepository.findById(id).orElseThrow( () -> 
				new AccountNotFoundException("Id: " + id + " not found"));
		return dependent;
	}

}
