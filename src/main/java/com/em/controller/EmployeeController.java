package com.em.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.em.entity.Employee;
import com.em.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeRepo;

	@PostMapping("/add")
	public Employee postemployee(@RequestBody Employee employee) {
		return employeeRepo.postemployee(employee);
	}

	@GetMapping("/get")
	public List<Employee> getAllEmployee() {
		return employeeRepo.getalldetails();
	}
	
	@DeleteMapping("/del/{eid}")
	public void deleteemployee(@PathVariable long eid) {
        employeeRepo.deleteemployee(eid);
	}
	@PutMapping("/all")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		return employeeRepo.updateEmployee(theEmployee);
	}
	@PutMapping("/edit/{eid}")
	public ResponseEntity<Employee> updateCustomerById(@PathVariable Long eid,@RequestBody Employee employee)
	{
		Employee updatedEmployee=employeeRepo.updateEmployee(eid,employee);
		if(updatedEmployee==null)
		    return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(updatedEmployee);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getCustomerById(@PathVariable Long eid)
	{
		Employee employee=employeeRepo.getCustomerById(eid);
		if(employee==null)
		    return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(employee);
	}
	
}