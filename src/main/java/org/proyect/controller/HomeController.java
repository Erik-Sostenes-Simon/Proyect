package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.fxml.FXML;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.proyect.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Tab tabViewStudents, tabApprovedStudents, tabFailedStudents;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      tabViewStudents.setContent(App.loadView("allStudents.fxml"));
      tabApprovedStudents.setContent(App.loadView("approvedStudents.fxml"));
      tabFailedStudents.setContent(App.loadView("failedStudents.fxml"));
    }

    @FXML
    public void showViewAddStudent(ActionEvent event) throws IOException {
        App.setRoot("addStudent");
        /*FXMLLoader loader = App.loadFXMlView("addStudent");
        Parent root = loader.load();

        AddStudentController addStudentController = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();*/
    }
}
