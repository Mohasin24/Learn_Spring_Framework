package com.mapping.demo;

import com.mapping.demo.dao.AppDAO;
import com.mapping.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner ->{
			
//			createCourseAndStudents(appDAO);
//			getTheCourseAndStudentByCourseId(appDAO);
//			getTheStudentAndCoursesByStudentId(appDAO);
//			addMoreCourseToStudent(appDAO);
//			deleteTheCourseById(appDAO);
			deleteStudentById(appDAO);
		};
	}

	private void deleteStudentById(AppDAO appDAO)
	{
		int theId = 3;
		System.out.println("Deleting the student with id : " + theId);
		appDAO.deleteStudent(theId);
		System.out.println("Done!");
	}

	private void addMoreCourseToStudent(AppDAO appDAO)
	{
		int theId = 1;

		// get the student with associated course
		Student student = appDAO.findStudentAndCoursesByStudentId(theId);

		//create the new course
		Course course = appDAO.findCourseById(14);

		//add course to student
		student.addCourse(course);

		System.out.println("Adding more courses to student : " + student );
		// save
		appDAO.updateStudent(student);

		System.out.println("Done!");
	}

	private void getTheStudentAndCoursesByStudentId(AppDAO appDAO)
	{
		int theId = 1;
		System.out.println("Finding the student with id : " + theId);
		Student student = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Student : " + student);
		System.out.println("Associated courses : " + student.getCourseList());
		System.out.println("Done!");
	}


	private void getTheCourseAndStudentByCourseId(AppDAO appDAO)
	{
		int theId = 10;
		Course course = appDAO.findCourseAndStudentByCourseId(theId);

		System.out.println("Course for id : " + theId + " is : " + course);
		System.out.println("Student for course are : " + course.getStudentList());
		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO)
	{
		// create course
		Course course = new Course("Java Full Stack");

		// create student's
		Student tempStudent1 = new Student("Mohasin","Patel","mohasin@gmail.com");
		Student tempStudent2 = new Student("John","Doe","john@gmail.com");
		Student tempStudent3 = new Student("Susan","Gilbert","susan@gmail.com");

		// add students to the course
		course.addStudent(tempStudent1);
		course.addStudent(tempStudent2);
		course.addStudent(tempStudent3);

		System.out.println("Saving the course : " + course);
		System.out.println("Associated Students : " + course.getStudentList());

		//save the course
		appDAO.save(course);

		System.out.println("Done!");
	}

	private void deleteTheCourseAndReviewsByCourseId(AppDAO appDAO)
	{
		int theId = 11;
		System.out.println("Deleting the course with review with id : " + theId);
		appDAO.deleteCourseAndReviewByCourseId(theId);
		System.out.println("Done!");
	}

	private void getTheCourseAndReviewsByCourseId(AppDAO appDAO)
	{
		int theId = 10;
		System.out.println("Getting the course details with the id : " + theId);

		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println("Course : " + tempCourse);
		System.out.println("Course Reviews : " + tempCourse.getReviewList());
	}

	private void createCourseAndReview(AppDAO appDAO)
	{
		// create course
		Course tempCourse = new Course("Learn Python");

		//add some review
		tempCourse.addReview(new Review("Great course"));
		tempCourse.addReview(new Review("Must take the course"));
		tempCourse.addReview(new Review("Not that much impressive course"));

		System.out.println("Saving the course : " + tempCourse);
		System.out.println(tempCourse.getReviewList());

		//save course
		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteTheCourseById(AppDAO appDAO)
	{
		int theId = 14;
		System.out.println("Deleting the course with id : " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void deleteTheInstructorById(AppDAO appDAO)
	{
		int theId = 3;

		System.out.println("Deleting the instructor with id : " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void updateTheCourse(AppDAO appDAO)
	{
		int theId = 12;

		System.out.println("Finding the course with id : " + theId);

		//get the course
		Course course = appDAO.findCourseById(theId);

		//make changes
		course.setTitle("Full Stack Web Development with MERN stack");

		appDAO.updateCourse(course);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO)
	{
		int theId = 3;

		//get the instructor
		Instructor instructor = appDAO.findById(theId);

		System.out.println("Updating the instructor with id : " + theId);
		//update the instructor
		instructor.setLastName("Bobby");

		//final update the instructor to database
		appDAO.update(instructor);

		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO)
	{
		int theId = 3;

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("The instructor : " + instructor.fullName());
		System.out.println("Courses : " + instructor.getCourseList());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO)
	{
		int theId = 3;

		// find the instructor
		Instructor instructor = appDAO.findById(theId);

		System.out.println("instructor : " + instructor);

		// get the instructor specific courses
		List<Course> list = appDAO.findCourseByInstructorId(theId);

		// set the course to the instructor
		instructor.setCourseList(list);

		System.out.println("The instructor : " + instructor.getFirstName() +" " + instructor.getLastName());
		System.out.println("Courses : " + instructor.getCourseList());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO)
	{
		int theId = 1;
		Instructor instructor = appDAO.findById(theId);

		System.out.println("instructor : " + instructor);
		System.out.println("Courses : " + instructor.getCourseList());
		System.out.println("Done!");
	}

	private void createInstructorWithCourse(AppDAO appDAO)
	{
		Instructor tempInstructor =
				new Instructor("Chad","Darby","darby@gmail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.youtube.com","Coding");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course cs1 = new Course("Spring Boot");
		Course cs2 = new Course("React");

		tempInstructor.add(cs1);
		tempInstructor.add(cs2);

		System.out.println("Saving instructor " + tempInstructor);
		System.out.println("The courses " + tempInstructor.getCourseList());
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}

	private void deleteInstructorDetailById(AppDAO appDAO)
	{
		int theId =7;
		appDAO.deleteInstructorDetailById(theId);
	}

	private void findInstructorDetailById(AppDAO appDAO)
	{
		int theId = 4;

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println(tempInstructorDetail.getInstructor());
	}

	private void deleteById(AppDAO appDAO)
	{
		int id = 5;
		System.out.println("Deleting instructor with id : " + id);
		appDAO.deleteById(id);
		System.out.println("done");
	}

	private void findById(AppDAO appDAO)
	{
		Instructor tempInstructor = appDAO.findById(6);
		System.out.println(tempInstructor);
	}

	private void createInstructor(AppDAO appDAO)
	{
//		1st entry
//		Instructor tempInstructor =
//				new Instructor("Mohasin","Patel","mohasin@gmail.com");
//
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail("https://www.youtube.com","Coding");

//		2nd entry
//		Instructor tempInstructor =
//				new Instructor("Ravi","Kumar","ravi@gmail.com");
//
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail("https://www.youtube.com","Riding");

//		3rd entry
		Instructor tempInstructor =
				new Instructor("John","Doe","mohasin@gmail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.youtube.com","Cooking");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor : " + tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("Done");
	}
}
