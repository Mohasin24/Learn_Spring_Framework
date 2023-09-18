package com.employees.crud.service;

import com.employees.crud.dao.EmployeeDao;
import com.employees.crud.dao.EmployeeEmployeeDaoImpl;
import com.employees.crud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEmployeeServiceDaoImpl implements EmployeeServiceDao
{
    private EmployeeDao employeeDao;

    public EmployeeEmployeeServiceDaoImpl(EmployeeDao employeeDao)
    {
        this.employeeDao=employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
