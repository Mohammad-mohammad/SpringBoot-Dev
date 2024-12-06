package com.moha.cruddemo;

import com.moha.cruddemo.dao.AppDAO;
import com.moha.cruddemo.entity.Instructor;
import com.moha.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {

		int id =1;

		System.out.println("Deleting instructor id: "+ id);

		appDAO.deleteInstructorById(id);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {

		int id=1;
		System.out.println("Finding instructor id: "+ id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: "+ instructor );

		System.out.println("the associated instructorDetail only: "+ instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor = new Instructor("Madhu", "Patel", "patel@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.hjvj/youtube", "guitar");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: "+ instructor);

		appDAO.save(instructor);

		System.out.println("Done!");
	}

}
