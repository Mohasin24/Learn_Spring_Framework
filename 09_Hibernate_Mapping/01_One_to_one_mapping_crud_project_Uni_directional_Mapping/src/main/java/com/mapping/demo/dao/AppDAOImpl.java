package com.mapping.demo.dao;

import com.mapping.demo.entity.Instructor;
import com.mapping.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class AppDAOImpl implements AppDAO
{
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor)
    {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);
        return tempInstructor;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);

        entityManager.remove(tempInstructor);
    }

}
