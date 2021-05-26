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
    private Assistance assistance;

    {assistance = new Assistance();}
    @Override
    public void updateAssistance(String tuition, Assistance assistance) {
        connection = DAO.getConnection();
    }
    // nameAssistance    | idStudent
    @Override
    public void addAssistance(String tuition, String assistance1) {
        try{
            connection = DAO.getConnection();
            ps = connection.prepareStatement("INSERT INTO Assists(nameAssistance, idStudent) VALUES(?, ?)");
            ps.setString(1, assistance1);
            ps.setString(2, tuition);
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
        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("SELECT nameAssistance FROM Assists WHERE idStudent = ?");
            ps.setString(1, tuition);
            rs = ps.executeQuery();
            while(rs.next()) {
                loadAssistance(rs.getString("nameAssistance"));
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

    private void loadAssistance(String assistance1){
        if (assistance1.equals("Asistencia en Consejería Académica"))
            assistance.setAssistanceInAcademicCounseling(assistance1);
        if(assistance1.equals("Asistencia Psicologica"))
            assistance.setPsychologyAssistance(assistance1);
        if(assistance1.equals("Asistencia Médica"))
            assistance.setMedicalServiceAssistance(assistance1);
        if(assistance1.equals("Asistencia en Servicio Social"))
            assistance.setAssistanceInSocialService(assistance1);
    }
}

