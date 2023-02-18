package com.rajesh.gettingstartedspringboot.courseapi;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CourseRepository {
    ArrayList<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course("1", "Spring Boot", "Spring Boot Course"));
        courses.add(new Course("2", "Java", "Java Course"));
        courses.add(new Course("3", "Python", "Python Course"));
    }
}
