package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.proyect.App;
import org.proyect.model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    private Label lblNameStudent, lblGroup, lblGrade, lblTuition, lblTotalAverage, lblCanalization, lblNu,
            lblCounseling, lblPsychology, lblMedical, lblSocial;
    @FXML
    private TextArea txtReasonForDisapproval;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void setStudent(Student student, int n) {
        lblNu.setText("N."+n);
        lblNameStudent.setText(student.getNameStudent());
        lblGroup.setText(student.getGroup());
        lblGrade.setText(String.valueOf(student.getGrade()));
        lblTuition.setText(student.getTuition());
        lblTotalAverage.setText(String.valueOf(student.getTotalAverage()));
        lblCanalization.setText(String.valueOf(student.getCanalization()));
        lblCounseling.setText(validateAssistance(student.getAssistance().getAssistanceInAcademicCounseling()));
        lblPsychology.setText(validateAssistance(student.getAssistance().getPsychologyAssistance()));
        lblMedical.setText(validateAssistance(student.getAssistance().getMedicalServiceAssistance()));
        lblSocial.setText(validateAssistance(student.getAssistance().getAssistanceInSocialService()));
        txtReasonForDisapproval.setText(student.getReasonForDisapproval());
    }
    private String validateAssistance(String assistance) {
        return assistance.isEmpty() ? "No" :"Si";
    }
    public void editStudent(ActionEvent event) throws IOException {
        App.setRoot("dialogStudent");
    }
}
