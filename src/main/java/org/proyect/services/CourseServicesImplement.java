package org.proyect.services;

import org.proyect.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseServicesImplement implements CourseServices{
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<Course> courses;
    {courses = new ArrayList<>();}
    @Override
    public void updateCourse(String enrollment, Course course) {

    }
//idCourse | nameCourse | evaluationUnit | idStudent | qualification
    @Override
    public List<Course> getByIdCourse(String tuition) {
        if(tuition == null)
            throw new RuntimeException("Tuition cannot be null");
        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("SELECT  nameCourse, qualification, evaluationUnit FROM Courses WHERE idStudent = ?");
            ps.setString(1, tuition);
            rs = ps.executeQuery();
            while(rs.next())
                courses.add(new Course(rs.getString("nameCourse"), rs.getDouble("qualification"), rs.getInt("evaluationUnit")));

            DAO.close(connection, ps, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courses;
    }
}
