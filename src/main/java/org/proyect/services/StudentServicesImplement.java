package org.proyect.services;
import org.proyect.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void addStudent(Student student) {
        if(student == null)
            throw new RuntimeException("Student cannot be null");

        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("INSERT INTO Students(idStudent, nameStudent, reasonForDisapproval, totalAverage, canalization, groupS, grade, idManager) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, student.getTuition());
            ps.setString(2, student.getNameStudent());
            ps.setString(3, student.getReasonForDisapproval());
            ps.setDouble(4, student.getTotalAverage());
            ps.setBoolean(5, student.getCanalization());
            ps.setString(6, student.getGroup());
            ps.setInt(7, student.getGrade());
            ps.setString(8, student.getIdManager());
            int result = ps.executeUpdate();

            if(result > 0)
                System.out.println("Student successfully added");
            DAO.close(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error {0}", e.getMessage());
        }
    }

    @Override
    public void deleteStudent(String tuition)  {
        if(tuition.isBlank())
            throw new RuntimeException("Student cannot be null");

        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("DELETE FROM Students WHERE idStudent=?");
            ps.setString(1, tuition);
            int result = ps.executeUpdate();

            if(result > 0)
                System.out.println("Student successfully deleted");
            DAO.close(connection, ps, rs);
        } catch (SQLException e) {
            System.out.println("Error"+ e.getMessage());
        }
    }

    @Override
    public void updateStudent(String tuition, Student student) throws SQLException {
        if(student == null)
            throw new RuntimeException("Student cannot be null");

        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("UPDATE Students SET idStudent=?, nameStudent=?, reasonForDisapproval=?, totalAverage=?, canalization=?, groupS=?, grade=? WHERE idStudent=?");
            ps.setString(1, student.getTuition());
            ps.setString(2, student.getNameStudent());
            ps.setString(3, student.getReasonForDisapproval());
            ps.setDouble(4, student.getTotalAverage());
            ps.setBoolean(5, student.getCanalization());
            ps.setString(6, student.getGroup());
            ps.setInt(7, student.getGrade());
            ps.setString(8, tuition);
            int result = ps.executeUpdate();

            if(result > 0)
                System.out.println("Student successfully update");
            DAO.close(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error {0}", e.getMessage());
        }

    }

    @Override
    public Map<Integer, Student> getAllStudent()  {
        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("SELECT * FROM Students");
            rs = ps.executeQuery();
            Integer key = 1;
            while(rs.next())
                studentsList.put(key++, new Student(rs.getString("idStudent"), rs.getString("nameStudent"),
                        rs.getString("reasonForDisapproval"), rs.getDouble("totalAverage"), rs.getBoolean("canalization"),
                        rs.getString("groupS"), rs.getInt("grade"), rs.getString("idManager")));

            DAO.close(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error {0}", e.getMessage());
        }
        return studentsList;
    }
    //you get a student for his tuition
    @Override
    public Student getByIdStudent(String tuition){
        Student student = null;
        if(tuition.isBlank())
            throw new RuntimeException("Student cannot be null");
        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("SELECT * FROM Students WHERE idStudent = ?");
            ps.setString(1, tuition);
            rs = ps.executeQuery();

            while(rs.next())
                student = new Student(rs.getString("idStudent"), rs.getString("nameStudent"), rs.getString("reasonForDisapproval"),
                        Double.valueOf(rs.getString("totalAverage")), Boolean.valueOf(rs.getString("canalization")),
                        rs.getString("groupS"), Integer.valueOf(rs.getString("grade")), rs.getString("idManager"));

            DAO.close(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error {0}", e.getMessage());
        }
        return student;
    }
}
