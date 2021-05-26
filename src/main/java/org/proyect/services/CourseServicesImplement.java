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
    @Override
    public List<Course> getByIdCourse(String tuition) {
        if(tuition == null)
            throw new RuntimeException("Tuition cannot be null");
        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("SELECT  * FROM Courses WHERE idStudent = ?");
            ps.setString(1, tuition);
            rs = ps.executeQuery();
            while(rs.next())
                courses.add(new Course(rs.getString("idCourse"), rs.getString("nameCourse"),
                        rs.getString("nameManager"),  rs.getInt("evaluationUnit"),
                        rs.getString("keyGroup"), rs.getString("periodC"), rs.getDouble("qualification"),
                        rs.getString("idStudent"), rs.getString("idManager")));

            DAO.close(connection, ps, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courses;
    }
    @Override
    public void addCourse(String tuition, Course course) {
        try{
            Connection connection = DAO.getConnection();
            ps = connection.prepareStatement("INSERT INTO Courses(idCourse, nameCourse,  nameManager,  evaluationUnit," +
                    "keyGroup, periodC, qualification, idStudent, idManager) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, course.getIdCourse());
            ps.setString(2,course.getNameCourse());
            ps.setString(3, course.getNameManager());
            ps.setInt(4, course.getEvaluationUnit());
            ps.setString(5, course.getKeyGroup());
            ps.setString(6, course.getPeriodC());
            ps.setDouble(7, course.getQualification());
            ps.setString(8, course.getIdStudent());
            ps.setString(9, course.getIdManager());

            int result = ps.executeUpdate();

            if(result > 0)
                System.out.println("Course successfully added");

            DAO.close(connection, ps, rs);
        }catch(Exception ex) {
            System.out.println("Error"+ ex.getMessage());
        }
    }
    @Override
    public void deleteCourse(String tuition) {
        Connection connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("DELETE FROM  Courses  WHERE idStudent=?");
            ps.setString(1, tuition);
            int result = ps.executeUpdate();

            if (result > 0)
                System.out.println("Course successfully delete");

            DAO.close(connection, ps, rs);
        } catch (SQLException ex) {
            System.out.println("Error"+ ex.getMessage());
        }
    }
}