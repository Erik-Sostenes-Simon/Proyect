package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class FailedStudents implements Initializable {
    @FXML
    private VBox vbxItemStudent;
    private Node[] nodes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       nodes = new Node[10];
        for (int i = 1; i < nodes.length; i++) {
            try {
                nodes[i] = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("failedStudentDescription.fxml")));
                vbxItemStudent.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
