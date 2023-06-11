package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runnner -> {
		//	createInstructor(appDAO);
		//	findInstructor(appDAO);
		//	deleteInstructor(appDAO);
		//	findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};

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
