package org.proyect.services;

import org.proyect.model.Course;

import java.util.List;

interface CourseServices {
    public void updateCourse(String tuition, Course course);
    public List<Course> getByIdCourse(String tuition);
    public void addCourse(String tuition, Course course);
    public void deleteCourse(String tuition);
}
