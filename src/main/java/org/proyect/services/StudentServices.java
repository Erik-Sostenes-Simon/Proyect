package org.proyect.services;

import org.proyect.model.Student;

interface StudentServices {
    public void addStudent(Student student);
    public void deleteStudent(String enrollment, Student student);
    public void updateStudent(String enrollment, Student student);
    public void getAllStudent(String enrollment,Student student);
    public void getByIdStudent(Student student);
}
