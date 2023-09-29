package com.mapping.demo.dao;

import com.mapping.demo.entity.Course;
import com.mapping.demo.entity.Instructor;
import com.mapping.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        return tempInstructorDetail;

    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId)
    {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        //set the instructorDetail object reference to the null inside the instructor object
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId)
    {
       TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id= :data", Course.class);

       query.setParameter("data",theId);

       List<Course> list = query.getResultList();

        return list;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId)
    {
         TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
                                       + "JOIN FETCH i.courseList "
                                       + "JOIN FETCH i.instructorDetail "
                                       + " where i.id = :data ", Instructor.class );

         query.setParameter("data",theId);

         Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor)
    {
        entityManager.merge(instructor);
    }
}
