package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.proyect.services.CourseServicesImplement;
import org.proyect.services.StudentServicesImplement;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteStudentController implements Initializable {
    @FXML
    private TextField txtTuition;
    private CourseServicesImplement courseServicesImplement;
    private StudentServicesImplement studentServicesImplement;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseServicesImplement = new CourseServicesImplement();
        studentServicesImplement = new StudentServicesImplement();
    }

    @FXML
    public void deleteStudent(ActionEvent event) {
        courseServicesImplement.deleteCourse(txtTuition.getText());
        studentServicesImplement.deleteStudent(txtTuition.getText());
    }
}
