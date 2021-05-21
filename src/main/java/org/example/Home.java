package org.example;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.fxml.FXML;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private Tab tabViewStudents, tabApprovedStudents, tabFailedStudents;
    private  Node viewStudents;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      tabViewStudents.setContent(loadView("allStudents.fxml"));
      tabApprovedStudents.setContent(loadView("approvedStudents.fxml"));
      tabFailedStudents.setContent(loadView("failedStudents.fxml"));
    }
    private Node loadView(String view) {
        try {
            viewStudents = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(view)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return viewStudents;
    }
}
