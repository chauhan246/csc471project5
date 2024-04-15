package com.csc471.project5.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.hibernate.dialect.SybaseASESqlAstTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.csc471.project5.model.Dependent;
import com.csc471.project5.model.Employee;
import com.csc471.project5.service.DependentService;
import com.csc471.project5.service.EmployeeService;

@Controller
public class EmpDepController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DependentService dependentService;
	
	@GetMapping(value = {"/","/home"})
	public String home(Model model) {
		System.out.println("Get All Employees");
		model.addAttribute("allEmps", employeeService.getAllEmps());
		return "emp-home";
	}
	
	@GetMapping("/addEmp")
	public String addEmp(Model model) {
		System.out.println("Add New Employee");
		Employee employee = new Employee();
		model.addAttribute("newEmp", employee);
		return "add-emp";
	}
	
	@PostMapping("/addNewEmp")
	public String addNewEmp(Employee employee) {
		System.out.println(employee.toString());
		try {
			employeeService.addNewEmp(employee);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}
	
	@GetMapping("/updateEmp/empSsn={ssn}")
	public String updateEmp(@PathVariable String ssn, Model model) {
		System.out.println("Update employee with SSN = " + ssn);
		try {
			Employee employee = employeeService.getEmployee(ssn);
			model.addAttribute("emp",employee);
			return "update-emp";
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/home";
	}
	
	@PostMapping("/updateEmpDetails")
	public String updateEmpDetails(Employee employee) {
		System.out.println(employee.toString());
		try {
			employeeService.updateEmp(employee);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}
	
	@GetMapping("/deleteEmp/empSsn={ssn}")
	public String deleteEmp(@PathVariable String ssn) {
		System.out.println("Delete employee with SSN = " + ssn);
		employeeService.deleteEmp(ssn);
		return "redirect:/home";
	}
	
	@GetMapping("/addDep")
	public String addDep(Model model) {
		System.out.println("Add New Dependent");
		
		List<Employee> empList = employeeService.getAllEmps();
		model.addAttribute("empList", empList);
		
		Dependent dependent = new Dependent();
		Employee employee = new Employee();
		dependent.setEmployee(employee);
		
		model.addAttribute("newDep", dependent);
		return "add-dep";
	}
	
	@PostMapping("/addNewDep")
	public String addNewDep(Dependent dependent) {
		System.out.println(dependent.toString());
		System.out.println(dependent.getEmployee().toString());
		try {
			dependentService.addNewDep(dependent);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/home";
	}
	
	@GetMapping("/getAllDep/empSsn={ssn}")
	public String getAllDep(@PathVariable String ssn, Model model) {
		System.out.println("Get All Dependents for Employee SSN: " + ssn);
		try {
			List<Dependent> dependents = dependentService.getAllDep(employeeService.getEmployee(ssn));
			model.addAttribute("allDeps", dependents);
			return "dep-home";
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		} 
		
		return "redirect:/home";
	}
	
	@GetMapping("/updateDep/depId={id}")
	public String updadeDep(@PathVariable int id, Model model) {
		System.out.println("Update Dependent with Id = " + id);
		
		try {
			Dependent dependent = dependentService.getDep(id);
			model.addAttribute("dep",dependent);
			return "update-dep";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}
	
	@PostMapping("/updateDepDetails")
	public String updateDepDetails(Dependent dependent) {
		
		return "dep-home";
	}
	
}
