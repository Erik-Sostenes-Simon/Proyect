package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.proyect.services.CourseServicesImplement;
import org.proyect.services.StudentServicesImplement;
import org.proyect.services.AssistanceServicesImplement;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteStudentController implements Initializable {
    private CourseServicesImplement courseServicesImplement;
    private StudentServicesImplement studentServicesImplement;
    private AssistanceServicesImplement assistanceServicesImplement;

    @FXML
    private TextField txtTuition;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseServicesImplement = new CourseServicesImplement();
        studentServicesImplement = new StudentServicesImplement();
        assistanceServicesImplement = new AssistanceServicesImplement();
    }

    @FXML
    public void deleteStudent(ActionEvent event) {
        courseServicesImplement.deleteCourse(txtTuition.getText());
        assistanceServicesImplement.deleteByIdAssistance(txtTuition.getText());
        studentServicesImplement.deleteStudent(txtTuition.getText());
    }
}
