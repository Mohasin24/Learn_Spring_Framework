package com.mapping.demo.dao;

import com.mapping.demo.entity.Course;
import com.mapping.demo.entity.Instructor;
import com.mapping.demo.entity.InstructorDetail;
import com.mapping.demo.entity.Student;

import java.util.List;

public interface AppDAO
{
    void save(Instructor instructor);
    Instructor findById(int theId);
    void deleteById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
    List<Course> findCourseByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor instructor);
    
    void updateCourse(Course course);

    Course findCourseById(int theId);
    void deleteInstructorById(int theId);

    void deleteCourseById(int theId);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int theId);

    void deleteCourseAndReviewByCourseId(int theId);

    Course findCourseAndStudentByCourseId(int theId);

    Student findStudentById(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    void updateStudent(Student student);

    void deleteStudent(int theId);
}
