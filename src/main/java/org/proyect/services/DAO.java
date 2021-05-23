package org.proyect.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    private static final String PATH;
    private static final String USER;
    private static final String PASSWORD;

    //Static variables
    static {
        PATH = "jdbc:mysql://localhost:3306/advisory_administrator?autoReconnect=true&useSSL=false";
        USER = "root";
        PASSWORD = "Loindeseable09";
    }
    //My connection baseData
    public static Connection getConnection() {
        Connection myConnection = null;
        try {
            myConnection = DriverManager.getConnection(PATH, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            Logger.getLogger( "Ocurrió un error: {0}", e.getMessage());
        }
        return myConnection;
    }
    public static void close(Connection c, PreparedStatement p, ResultSet r) throws SQLException {
        if(c != null)
            c.close();
        if(p != null)
            p.close();
        if(r != null)
            r.close();
    }
}
