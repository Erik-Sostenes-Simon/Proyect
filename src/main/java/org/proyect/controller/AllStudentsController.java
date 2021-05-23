package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import org.proyect.App;
import org.proyect.services.StudentServicesImplement;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AllStudentsController implements Initializable {
    private static Scene scene;
    private StudentServicesImplement studentServicesImplement;
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
            System.out.println(e.getMessage());
        }
        return myConnection;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentServicesImplement = new StudentServicesImplement();
    }

    public void searchStudent(ActionEvent event) throws IOException {
        App.setRoot("dialogStudent");
        System.out.println(studentServicesImplement.getAllStudent());

    }
}