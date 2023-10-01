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
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        return tempInstructor;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        return tempInstructorDetail;

    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        //set the instructorDetail object reference to the null inside the instructor object
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id= :data", Course.class);

        query.setParameter("data", theId);

        List<Course> list = query.getResultList();

        return list;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
                + "JOIN FETCH i.courseList "
                + "JOIN FETCH i.instructorDetail "
                + " where i.id = :data ", Instructor.class);

        query.setParameter("data", theId);

        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int theId) {
        Course course = entityManager.find(Course.class, theId);
        return course;
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //find the instructor
        Instructor instructor = entityManager.find(Instructor.class, theId);

        // get all the courses associated with the instructor
        List<Course> courses = instructor.getCourseList();

        //remove all course association with the instructor
        for (Course theCourse : courses) {
            theCourse.setInstructor(null);
        }

        //delete the instructor
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        //get the course by id
        Course course = entityManager.find(Course.class, theId);

        //remove the course
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.reviewList "
                        + "where c.id = :data ", Course.class
        );

        query.setParameter("data",theId);

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    @Transactional
    public void deleteCourseAndReviewByCourseId(int theId)
    {
        Course course = entityManager.find(Course.class, theId);
        entityManager.remove(course);
    }


}
