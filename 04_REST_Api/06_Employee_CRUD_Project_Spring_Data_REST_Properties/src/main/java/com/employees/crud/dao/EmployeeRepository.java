package com.employees.crud.dao;

import com.employees.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members") //changes the endpoint name
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
    // that's it no need to write any code
}
