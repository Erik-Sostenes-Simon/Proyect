package org.proyect.services;

import org.proyect.model.Student;

import java.sql.SQLException;
import java.util.Collection;

interface StudentServices {
    public void addStudent(Student student) throws SQLException;
    public void deleteStudent(String enrollment) throws SQLException;
    public void updateStudent(String enrollment, Student student) throws SQLException;
    public Collection getAllStudent() throws SQLException;
    public Student getByIdStudent(String enrollment) throws SQLException;
}