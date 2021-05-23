package org.proyect.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogStudentController implements Initializable {
    @FXML
    private GridPane gridCourses;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            for(int i = 1; i < 10; i++)
            gridCourses.addRow(i, new Label("Ingles"), new Label("80"));
    }
}
