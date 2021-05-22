package org.proyect.controller;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import org.proyect.App;


public class ApprovedStudents implements Initializable {
    @FXML
    private VBox vbxItemStudent;
    private Node[] nodes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       nodes = new Node[10];
        for (int i = 1; i < nodes.length; i++) {
            try {
                nodes[i] = App.loadView("approvedStudentDescription.fxml");
                vbxItemStudent.getChildren().add(nodes[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}