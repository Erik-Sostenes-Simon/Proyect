package org.proyect.services;

import org.proyect.model.Student;

import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentServicesImplement implements StudentServices {
    private Map<Integer, Student> studentsList;
    Connection connection;

    public StudentServicesImplement() {
        studentsList = new HashMap<>();
    }

    @Override
    public void addStudent(Student student){
        if(student == null)
            throw new RuntimeException("Student cannot be null");

        
    }

    @Override
    public void deleteStudent(String enrollment, Student student) {

    }

    @Override
    public void updateStudent(String enrollment, Student student) {

    }

    @Override
    public Collection getAllStudent(String enrollment, Student student) {
        return null;
    }


    @Override
    public Student getByIdStudent(Student student) {
        return null;
    }
}
