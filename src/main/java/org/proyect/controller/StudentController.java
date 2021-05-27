package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
        return assistance == null ? "NO" :"SI";
    }
    public void editStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = App.loadFXMlView("dialogStudent");
        Parent root = loader.load();
        DialogStudentController dialogStudentController = loader.getController();
        dialogStudentController.initCourses(lblTuition.getText(), lblNameStudent.getText());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
