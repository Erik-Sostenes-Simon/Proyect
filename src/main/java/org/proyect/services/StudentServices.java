package org.proyect.services;

import org.proyect.model.Student;

import java.util.Collection;

interface StudentServices {
    public void addStudent(Student student);
    public void deleteStudent(String enrollment, Student student);
    public void updateStudent(String enrollment, Student student);
    public Collection getAllStudent(String enrollment, Student student);
    public Student getByIdStudent(Student student);
}