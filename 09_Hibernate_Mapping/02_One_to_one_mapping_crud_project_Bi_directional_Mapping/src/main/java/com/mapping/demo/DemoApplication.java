package com.mapping.demo;

import com.mapping.demo.dao.AppDAO;
import com.mapping.demo.entity.Instructor;
import com.mapping.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			deleteInstructorDetailById(appDAO);
		};
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
