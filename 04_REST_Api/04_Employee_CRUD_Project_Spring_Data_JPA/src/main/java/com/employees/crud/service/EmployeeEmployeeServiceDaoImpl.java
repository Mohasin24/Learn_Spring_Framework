package com.employees.crud.service;

import com.employees.crud.dao.EmployeeRepository;
import com.employees.crud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeEmployeeServiceDaoImpl implements EmployeeServiceDao
{
    private EmployeeRepository employeeRepository;

    public EmployeeEmployeeServiceDaoImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id)
    {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmployee = null;

        if(result.isPresent())
        {
            theEmployee = result.get();
        }
        else
        {
            throw new RuntimeException("Employee not found with id : " + id);
        }

        return theEmployee;
    }

    //here no need to provide the @Transactional annotation as JPA provides it auto
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
