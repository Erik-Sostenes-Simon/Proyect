package org.proyect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import java.sql.*;
/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    private static final String PATH;
    private static final String USER;
    private static final String PASSWORD;
    private PreparedStatement ps;
    //Static variables
    static {
        PATH = "jdbc:mysql://localhost:3306/School?autoReconnect=true&useSSL=false";
        USER = "root";
        PASSWORD = "Loindeseable09";
    }
    //My connection baseData
    public static Connection getConnection() throws SQLException{
        Connection myConnection = null;
        return myConnection = DriverManager.getConnection(PATH, USER, PASSWORD);
    }
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("home"), 1350,700);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String windows) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(loadFXML(windows)));
        stage.showAndWait();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static Node loadView(String view)  {
        Node viewStudents = null;
        try {
            viewStudents = FXMLLoader.load(Objects.requireNonNull(App.class.getResource(view)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return viewStudents;
    }
    public static void main(String[] args) {
        launch();
    }
}