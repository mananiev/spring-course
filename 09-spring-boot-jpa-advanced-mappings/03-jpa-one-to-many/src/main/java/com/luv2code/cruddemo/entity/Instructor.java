package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public Instructor setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Instructor setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Instructor setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Instructor setEmail(String email) {
        this.email = email;
        return this;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public Instructor setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
        return this;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Instructor setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }

    public void add(Course tempCourse) {
        if (courses== null) {
            courses = new ArrayList<>();
        }

        courses.add(tempCourse);
        tempCourse.setInstructor(this);
    }
}
