package com.mapping.demo;

import com.mapping.demo.dao.AppDAO;
import com.mapping.demo.entity.Course;
import com.mapping.demo.entity.Instructor;
import com.mapping.demo.entity.InstructorDetail;
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
//			createInstructor(appDAO);
//			findById(appDAO);
//			deleteById(appDAO);

			//bi directional mapping
//			findInstructorDetailById(appDAO);
//			deleteInstructorDetailById(appDAO);

//			createInstructorWithCourse(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
			
			updateInstructor(appDAO);
		};
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
