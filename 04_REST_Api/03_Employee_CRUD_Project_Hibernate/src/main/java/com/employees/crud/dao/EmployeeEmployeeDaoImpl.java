package com.employees.crud.dao;

import com.employees.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
@Repository
public class EmployeeEmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeEmployeeDaoImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        // Create query
        TypedQuery<Employee> query = entityManager.createQuery("From Employee",Employee.class);

        // Execute query
        List<Employee> list =  query.getResultList();

        // return the list
        return list;
    }

    @Override
    public Employee findById(int id)
    {
        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee)
    {
        // if id is 0 then it will add new employee else it will update the existing employee
        Employee dbEmployee = entityManager.merge(employee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int id)
    {
        Employee employee = entityManager.find(Employee.class,id);

        entityManager.remove(employee);
    }

}
