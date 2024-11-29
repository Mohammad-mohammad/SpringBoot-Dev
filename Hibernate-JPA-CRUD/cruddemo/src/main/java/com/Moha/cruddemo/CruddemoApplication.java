package com.Moha.cruddemo;

import com.Moha.cruddemo.DAO.StudentDAO;
import com.Moha.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createMultipleStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Mohammad", "Mohammad", "it.msm88@gmail.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: "+ tempStudent.getId());

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students object ...");
		Student tempStudent1 = new Student("Mohammad1", "Mohammad1", "it1.msm88@gmail.com");
		Student tempStudent2 = new Student("Mohammad2", "Mohammad2", "it2.msm88@gmail.com");
		Student tempStudent3 = new Student("Mohammad3", "Mohammad3", "it3.msm88@gmail.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}
}
