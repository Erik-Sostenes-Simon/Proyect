package org.proyect.services;

import org.proyect.model.Assistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
    @Override
    public Assistance getByIdAssistance(String tuition) {
        connection = DAO.getConnection();
        try {
            ps = connection.prepareStatement("SELECT nameAssistance FROM Assistances WHERE idStudent = ?");
            ps.setString(1, tuition);
            rs = ps.executeQuery();
            while(rs.next()) {
                loadAssistance(rs.getString("nameAssistance"));
            }
            DAO.close(connection, ps, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return assistance;
    }

    private void loadAssistance(String assistsance){
            if (assistsance.equals("Assistencia en consejería académica"))
                assistance.setAssistanceInAcademicCounseling(assistsance);
            if(assistsance.equals("Asistencia psicologica"))
                assistance.setPsychologyAssistance(assistsance);
            if(assistsance.equals("Assistencia médica"))
                assistance.setMedicalServiceAssistance(assistsance);
            if(assistsance.equals("Assistencia en servicio Social"))
                assistance.setAssistanceInSocialService(assistsance);
    }
}
