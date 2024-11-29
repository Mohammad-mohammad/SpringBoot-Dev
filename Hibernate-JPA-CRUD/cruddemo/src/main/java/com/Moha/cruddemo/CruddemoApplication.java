package com.Moha.cruddemo;

import com.Moha.cruddemo.DAO.StudentDAO;
import com.Moha.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			deleteStudent(studentDAO);
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

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Mohammad", "Mohammad", "it.msm88@gmail.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);

		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student: "+myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll();
		for (Student std : theStudents ){
			System.out.println(std);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByLastName("Mohammad");
		for (Student std : theStudents ){
			System.out.println(std);
		}
	}


	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		studentDAO.update(myStudent);

		System.out.println("Updated student: "+ myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId =3;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}
}
