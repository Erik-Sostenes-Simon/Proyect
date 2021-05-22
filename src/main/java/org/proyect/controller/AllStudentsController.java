package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import org.proyect.App;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllStudentsController implements Initializable {
    private static Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void searchStudent(ActionEvent event) throws IOException {
        App.setRoot("dialogStudent");
    }
}