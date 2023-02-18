package com.rajesh.gettingstartedspringboot.courseapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.courses;
    }

    public Course getCourseById(String id) {
        return courseRepository.courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Course addCourse(Course course) {
        courseRepository.courses.add(course);
        return course;
    }

    public Course updateCourse(String id, Course course) {
        Course courseToUpdate = getCourseById(id);
        courseToUpdate.setName(course.getName());
        courseToUpdate.setDescription(course.getDescription());
        return courseToUpdate;
    }

    public void deleteCourse(String id) {
        courseRepository.courses.removeIf(course -> course.getId().equals(id));
    }
}
