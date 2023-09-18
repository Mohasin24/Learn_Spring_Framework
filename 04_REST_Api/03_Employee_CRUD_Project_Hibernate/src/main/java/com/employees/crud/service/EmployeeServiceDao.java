package com.employees.crud.service;

import com.employees.crud.entity.Employee;

import java.util.List;

public interface EmployeeServiceDao
{
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
