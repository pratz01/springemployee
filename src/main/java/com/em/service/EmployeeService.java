package com.em.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.em.entity.Employee;
import com.em.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee postemployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	public List<Employee>getalldetails(){
		return employeeRepo.findAll();
	}
	public void deleteemployee(Long eid)
	{
		employeeRepo.deleteById(eid);
	}
	
	
	public Employee updateEmployee(Employee theEmployee) {
		return employeeRepo.save(theEmployee);
}
	public Employee updateEmployee(Long eid, Employee customer)
	{
		Optional<Employee> optionalEmployee=employeeRepo.findById(eid);
		if(optionalEmployee.isPresent())
		{
			Employee existingEmployee=optionalEmployee.get();
			existingEmployee.setEname(customer.getEname());
			existingEmployee.setEemail(customer.getEemail());
			existingEmployee.setEcontact(customer.getEcontact());
			return employeeRepo.save(existingEmployee);
		}
		return null;
	}
	public Employee getCustomerById(Long eid)
	{
		return employeeRepo.findById(eid).orElse(null);
	}
}