package com.moha.cruddemo;

import com.moha.cruddemo.dao.AppDAO;
import com.moha.cruddemo.entity.Course;
import com.moha.cruddemo.entity.Instructor;
import com.moha.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			//deleteInstructorDetail(appDAO);

			//createInstructorWithCourses(appDAO);

			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);

			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);

			updateCourse(appDAO);
		};
	}

	private void updateCourse(AppDAO appDAO) {
		int id =10;
		System.out.println("Finding course id: "+ id);
		Course course = appDAO.findCourseById(id);
		System.out.println("Course: "+ course );

		// update the course
		System.out.println("Updating course id: "+ id);
		course.setTitle("Enjoy simple things");
		appDAO.update(course);
		System.out.println("Updated course: "+ course );
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id =1;
		System.out.println("Finding instructor id: "+ id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: "+ instructor );

		// update the instructor
		System.out.println("Updating instructor id: "+ id);
		instructor.setLastName("Tester");
		appDAO.update(instructor);
		System.out.println("Updated instructor: "+ instructor );
		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding instructor id: "+ id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("instructor: "+ instructor );

		System.out.println("the associated courses: "+ instructor.getCourses());
		System.out.println("Done!");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding instructor id: "+ id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: "+ instructor );

		System.out.println("Finding Courses for instructor id: "+ id);
		List<Course> courseByInstructorId = appDAO.findCourseByInstructorId(id);
		instructor.setCourses(courseByInstructorId);
		System.out.println("the associated courses: "+ instructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding instructor id: "+ id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: "+ instructor );

		// Unless you explicitly define an eager fetch,
		// this will throw an exception because of fitch type default lazy
		System.out.println("the associated courses: "+ instructor.getCourses());

		System.out.println("Done!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor instructor = new Instructor("Suzan", "Patel", "patel@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "video games");
		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - the ultimate guid");
		Course course2 = new Course("Air Pinball master class");
		instructor.add(course1);
		instructor.add(course2);

		// save the instructor
		// Note: this will also save the courses
		// because of CascadeType.PERSIST
		System.out.println("Saving instructor: "+ instructor);
		System.out.println("The courses: "+ instructor.getCourses());
		appDAO.save(instructor);
		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int id =2;

		System.out.println("Deleting instructor detail id: "+ id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int id=2;

		System.out.println("Finding instructor detail id: "+ id);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("instructor detail: "+ instructorDetail );

		System.out.println("the associated instructor: "+ instructorDetail.getInstructor());

		System.out.println("Done!");
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
