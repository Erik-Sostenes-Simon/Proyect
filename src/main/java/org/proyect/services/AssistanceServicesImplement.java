package org.proyect.services;

import org.proyect.model.Assistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssistanceServicesImplement implements AssistanceServices{
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;


    @Override
    public void updateAssistance(String tuition,  String assistance1) {
        try{
            connection = DAO.getConnection();
            ps = connection.prepareStatement("UPDATE Assists SET nameAssistance=?, idStudent=? WHERE idStudent=?");
            ps.setString(1, assistance1);
            ps.setString(2, tuition);
            ps.setString(3, tuition);
            int result = ps.executeUpdate();

            if(result > 0)
                System.out.println("Assistance successfully updated");
            DAO.close(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error2 {0}", e.getMessage());
        }
    }
    // nameAssistance    | idStudent
    @Override
    public void addAssistance(String tuition, Assistance assistance1) {
        try{
            connection = DAO.getConnection();
            ps = connection.prepareStatement("INSERT INTO Assists(assistanceInAcademicCounseling, psychologyAssistance, " +
                    " medicalServiceAssistance, assistanceInSocialService, idStudent) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, assistance1.getAssistanceInAcademicCounseling());
            ps.setString(2, assistance1.getPsychologyAssistance());
            ps.setString(3, assistance1.getMedicalServiceAssistance());
            ps.setString(4, assistance1.getAssistanceInSocialService());
            ps.setString(5, tuition);
            int result = ps.executeUpdate();

            if(result > 0)
                System.out.println("Assistance successfully added");
            DAO.close(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error2 {0}", e.getMessage());
        }
    }

    @Override
    public Assistance getByIdAssistance(String tuition) {
        Assistance assistance = null;
        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("SELECT * FROM Assists WHERE idStudent = ?");
            ps.setString(1, tuition);
            rs = ps.executeQuery();
            while(rs.next()) {
                assistance = new Assistance(rs.getString("assistanceInAcademicCounseling"), rs.getString("psychologyAssistance"),
                rs.getString("medicalServiceAssistance"), rs.getString("assistanceInSocialService"));
            }
            DAO.close(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error {0}", e.getMessage());
        }
        return assistance;
    }

    @Override
    public void deleteByIdAssistance(String tuition) {
        try{
            Connection connection = DAO.getConnection();
            ps = connection.prepareStatement("DELETE FROM Assists WHERE idStudent = ?");
            ps.setString(1, tuition);

            int result = ps.executeUpdate();

            if(result > 0)
                System.out.println("Assistance successfully deleted");
            DAO.close(connection, ps, rs);
        }catch(SQLException e){
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error {0}", e.getMessage());
        }
    }
}

