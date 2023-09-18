package com.hibernate.cruddemo.dao;

import com.hibernate.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO
{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student)
    {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll()
    {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
//        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc",Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastname)
    {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",
                Student.class);
        theQuery.setParameter("theData",lastname);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student)
    {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id)
    {
        Student myStudent = entityManager.find(Student.class,id);

        entityManager.remove(myStudent);
    }

    @Override
    @Transactional
    public int deleteAll()
    {
        int num = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return num;
    }


}
