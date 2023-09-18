package com.hibernate.cruddemo.dao;

import com.hibernate.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO
{
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastname);
    void update(Student student);
    void delete(Integer id);

    int deleteAll();
}
