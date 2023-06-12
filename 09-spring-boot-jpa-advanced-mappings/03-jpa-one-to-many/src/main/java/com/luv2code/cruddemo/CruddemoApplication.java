package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runnner -> {
		//	createInstructor(appDAO);
		//	findInstructor(appDAO);
		//	deleteInstructor(appDAO);
		//	findInstructorDetail(appDAO);
		//	deleteInstructorDetail(appDAO);
		//	createInstructorWithCourses(appDAO);
		//	findInstructorWithCourses(appDAO);

		//	findCourseForInstructor(appDAO);

			findInstructorWithCoursesJoinFetch(appDAO);
		};

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;

		Instructor instructorByIdJoinFetch = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor:" + instructorByIdJoinFetch);
		System.out.println("Courses:" + instructorByIdJoinFetch.getCourses());
	}

	private void findCourseForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find the instructor id: " + theId);
		Instructor tempInstructorById = appDAO.findInstructorById(theId);

		System.out.println("tempinstructor" + tempInstructorById);

		List<Course> courseByInstructorId = appDAO.findCourseByInstructorId(theId);
		tempInstructorById.setCourses(courseByInstructorId);

		System.out.println("the associated courses: " + courseByInstructorId);
		System.out.println("done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find the instructor id: " + theId);
		Instructor tempInstructorById = appDAO.findInstructorById(theId);

		System.out.println("tempinstructor" + tempInstructorById);
		System.out.println("The associated course" + tempInstructorById.getCourses());

		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Susan", "Public", "susan@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.conm", "video games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar Ultimate guide");
		Course tempCourse2 = new Course("Pinball Masterclass");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor " + tempInstructor);
		System.out.println("The courses " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("DONE!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int idToDelete = 2;
		appDAO.deleteInstructorDetailById(idToDelete);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theIdOfInstructorDetail = 6;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theIdOfInstructorDetail);
		System.out.println("The Instructor Detail for Instructor with id " + theIdOfInstructorDetail + " is " + tempInstructorDetail );

		System.out.println("the associated instructor is " + tempInstructorDetail.getInstructor());
		System.out.println("DONE!");

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theIdToDelete = 4;
		System.out.println("Deleting instructor with id: " + theIdToDelete);
		appDAO.deleteInstructorById(theIdToDelete);
		System.out.println("deleted");
	}

	private void findInstructor(AppDAO appDAO) {
		int theIdToFind = 4;
		Instructor foundInstructor = appDAO.findInstructorById(theIdToFind);
		System.out.println("Instructor Found: " + foundInstructor);
	}

	private void createInstructor(AppDAO appDAO) {
		//create the instructor

		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		//create the instructorDetaul

		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.con/luv2code", "luv 2 code!!");

		//associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create the instructor

		Instructor tempInstructor2 = new Instructor("Madhu", "Paterl", "patel@luv2code.com");

		//create the instructorDetaul

		InstructorDetail tempInstructorDetail2 = new InstructorDetail("youtube.com/MadhuPatel", "Guitar");

		//associate the objects

		tempInstructor2.setInstructorDetail(tempInstructorDetail2);


		// save the instructor
		//This will also save the details object because of Cascadetype.all

		System.out.println("saving instructor: " + tempInstructor);
		System.out.println("saving instructor: " + tempInstructor2);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor2);
		System.out.println("Done");
			}

}
