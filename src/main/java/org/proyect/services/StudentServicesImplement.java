package org.proyect.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.proyect.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentServicesImplement implements StudentServices {
    private Map<Integer, Student> studentsList;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public StudentServicesImplement() {
        studentsList = new HashMap<>();
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        if(student == null)
            throw new RuntimeException("Student cannot be null");

        connection = DAO.getConnection();
        ps = connection.prepareStatement("INSER INTO Student() VALUES(?, ?, ?)");
        ps.setString(1, student.getTuition());

        int result = ps.executeUpdate();

        if(result > 0)
            System.out.println("Student successfully added");
    }

    @Override
    public void deleteStudent(String enrollment) throws SQLException {
        if(enrollment.isBlank())
            throw new RuntimeException("Student cannot be null");

        connection = DAO.getConnection();
        ps = connection.prepareStatement("DELETE FROM Student WHERE enrollment=?");
        ps.setString(1, enrollment);
        int result = ps.executeUpdate();

        if(result > 0)
            System.out.println("Student successfully deleted");
    }

    @Override
    public void updateStudent(String enrollment, Student student) throws SQLException {
        if(enrollment.isBlank())
            throw new RuntimeException("Student cannot be null");
        connection = DAO.getConnection();
        ps = connection.prepareStatement("UPDATE Student SET enrollment=?, nameStudent=? WHERE enrollment");
        ps.setString(1, student.getTuition());
        ps.setString(2, enrollment);

        int result = ps.executeUpdate();

        if(result > 0)
            System.out.println("Student successfully updated");

    }

    @Override
    public Map<Integer, Student> getAllStudent()  {
        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("SELECT * FROM Students");
            rs = ps.executeQuery();
            Integer key = 1;
            while(rs.next())
                studentsList.put(key++ ,new Student(rs.getString("idStudent"), rs.getString("nameStudent"),
                        rs.getString("reasonForDisapproval"), rs.getDouble("totalAvarage"), rs.getBoolean("canalization"),
                        rs.getString("groupS"), rs.getInt("grade"), rs.getString("idManager")));
            DAO.close(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error de conexión{0}", e.getMessage());
        }

        return studentsList;
    }
    //you get a student for his tuition
    @Override
    public Student getByIdStudent(String enrollment) throws SQLException {
        if(enrollment.isBlank())
            throw new RuntimeException("Student cannot be null");
        connection = DAO.getConnection();
        ps = connection.prepareStatement("SELECT * FROM Student");
        rs = ps.executeQuery();
        return null;
    }
}
