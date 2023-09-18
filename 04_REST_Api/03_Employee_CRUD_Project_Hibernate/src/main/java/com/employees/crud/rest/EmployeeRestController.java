package com.employees.crud.rest;

import com.employees.crud.entity.Employee;
import com.employees.crud.service.EmployeeEmployeeServiceDaoImpl;
import com.employees.crud.service.EmployeeServiceDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    private EmployeeServiceDao employeeServiceDao;

    public EmployeeRestController(EmployeeServiceDao employeeServiceDao)
    {
        this.employeeServiceDao=employeeServiceDao;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeServiceDao.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId)
    {
        Employee employee = employeeServiceDao.findById(employeeId);

        if(employee==null)
        {
            throw new RuntimeException("Employee not found with id - " + employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee)
    {
        employee.setId(0);

        Employee dbEmployee = employeeServiceDao.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        Employee dbEmployee = employeeServiceDao.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeServiceDao.findById(employeeId);

        if (employee==null)
        {
            throw new RuntimeException("\"Employee not found with id - \" + employeeId");
        }

        employeeServiceDao.deleteById(employeeId);

        return "Deleted employee with id- " + employeeId;
    }
}
