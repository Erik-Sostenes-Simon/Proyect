package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.fxml.FXML;
import org.proyect.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Tab tabViewStudents;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      tabViewStudents.setContent(App.loadView("allStudents.fxml"));
    }

    @FXML
    public void showViewAddStudent(ActionEvent event) throws IOException {
        App.setRoot("addStudent");
    }
    @FXML
    public void showViewDeleteStudent(ActionEvent event) throws IOException {
        App.setRoot("deleteStudent");
    }
    @FXML
    public void updateStudent(ActionEvent event) throws IOException {
        App.setRoot("idStudent");
    }
}
