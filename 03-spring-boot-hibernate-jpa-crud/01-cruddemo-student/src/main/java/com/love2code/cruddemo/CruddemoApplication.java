package com.love2code.cruddemo;

import com.love2code.cruddemo.dao.StudentDAO;
import com.love2code.cruddemo.entity.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            // createStudent(studentDAO);

             createMultipleStudents(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            // updateStudent(studentDAO);

            // deleteStudent(studentDAO);

            // deleteAll(studentDAO);

        };
    }

    private void deleteAll(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println(numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        long studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        //retrieve student based on the id primary key
        long studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        //change first name to scooby
        System.out.println("Updateing student...");
        myStudent.setFirstName("John");
        //update the student
        studentDAO.update(myStudent);

        //display the student
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudent = studentDAO.findByLastName("Bob");

        //display list of students
        for (Student student : theStudent) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        //display the list of students
        for (Student theStudent : theStudents) {
            System.out.println(theStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object ...");

        Student tempStudent  = new Student("Bob", "Bob", "bob@luv2code.com");


        //save the student
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        //display id of the saved student
        long theId = tempStudent.getId();
        System.out.println("Id of student saved is - " + theId);
        //retrieve student based on the id primary key

        Student foundStudent = studentDAO.findById(theId);

        // display student
        System.out.println(foundStudent.toString());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 new student objects ...");
        Student temo1Student = new Student("Paul", "Doe", "paul@luv2code.com");
        Student temo2Student = new Student("Mary", "Public", "mary@luv2code.com");
        Student temo3Student = new Student("Bonita", "Applebum", "bonita@luv2code.com");

        System.out.println("Saving the students");
        studentDAO.save(temo1Student);
        studentDAO.save(temo2Student);
        studentDAO.save(temo3Student);

    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student temoStudent = new Student("Paul", "Doe", "paul@luv2code.com");

        System.out.println("Saving the student");
        studentDAO.save(temoStudent);

        System.out.println("Saved student. Generated id: " + temoStudent.getId());



    }

}
