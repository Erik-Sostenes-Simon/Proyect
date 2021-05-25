package org.proyect.services;

import org.proyect.model.Course;

import java.util.List;

interface CourseServices {
    public void updateCourse(String enrollment, Course course);
    public List<Course> getByIdCourse(String tuition);
}
