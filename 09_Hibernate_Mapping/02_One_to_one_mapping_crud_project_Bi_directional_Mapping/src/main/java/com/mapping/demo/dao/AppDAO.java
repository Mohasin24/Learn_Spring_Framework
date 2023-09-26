package com.mapping.demo.dao;

import com.mapping.demo.entity.Instructor;
import com.mapping.demo.entity.InstructorDetail;

public interface AppDAO
{
    void save(Instructor instructor);
    Instructor findById(int theId);
    void deleteById(int theId);
    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
