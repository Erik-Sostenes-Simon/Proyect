package org.proyect.services;

import org.proyect.model.Student;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

interface StudentServices {
    public void addStudent(Student student) throws SQLException;
    public void deleteStudent(String enrollment) throws SQLException;
    public void updateStudent(String enrollment, Student student) throws SQLException;
    public Map<Integer, Student>  getAllStudent() throws SQLException;
    public Student getByIdStudent(String enrollment) throws SQLException;
}