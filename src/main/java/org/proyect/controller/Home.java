package org.proyect.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.fxml.FXML;
import org.proyect.App;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private Tab tabViewStudents, tabApprovedStudents, tabFailedStudents;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      tabViewStudents.setContent(App.loadView("allStudents.fxml"));
      tabApprovedStudents.setContent(App.loadView("approvedStudents.fxml"));
      tabFailedStudents.setContent(App.loadView("failedStudents.fxml"));
    }
}
