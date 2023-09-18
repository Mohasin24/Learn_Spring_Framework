package com.hibernate.cruddemo;

import com.hibernate.cruddemo.dao.StudentDAO;
import com.hibernate.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		String lastName = "Sharma";
		return runner ->
		{
			createStudent(studentDAO);

//			readAllStudent(studentDAO);

//			queryForStudentByLastName(lastName,studentDAO);

//			updatStudent(studentDAO);

//			readStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);
		};


	}

	private void deleteAllStudent(StudentDAO studentDAO)
	{
		System.out.println(studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 2;

		studentDAO.delete(id);
	}

	private void updatStudent(StudentDAO studentDAO)
	{
		int id = 1;

		Student myStudent = studentDAO.findById(id);

		myStudent.setFirstName("Chulbul");
		myStudent.setLastName("Pande");
		myStudent.setEmail("chulbulpande@gmail.com");

		studentDAO.update(myStudent);

	}

	public void queryForStudentByLastName(String lastName,StudentDAO studentDAO)
	{
		List<Student> list = studentDAO.findByLastName(lastName);

		for(Student obj : list)
		{
			System.out.println(obj);
		}
	}
	private void readAllStudent(StudentDAO studentDAO)
	{
		List<Student> list = studentDAO.findAll();

		for(Student obj : list)
		{
			System.out.println(obj);
		}
	}

	private void readStudent(StudentDAO studentDAO)
	{
//		Student temp = new Student("Ravi", "Sharma","ravi@gmail.com");
//
//		studentDAO.save(temp);
//
//		Student st = studentDAO.findById(temp.getId());
		List<Student> st = studentDAO.findByLastName("Pande");

		for(Student obj : st)
		{
			System.out.println(obj);
		}
	}

	private void createStudent(StudentDAO studentDAO)
	{
		System.out.println("Creating the student");
		Student temp = new Student("Mohasin","Patel","example@gmail.com");

		System.out.println("Saving the student......");
		studentDAO.save(temp);

		System.out.println("Student saved. Generated Student Id : " + temp.getId());
	}
}
