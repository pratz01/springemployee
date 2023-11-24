package com.em.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.em.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
