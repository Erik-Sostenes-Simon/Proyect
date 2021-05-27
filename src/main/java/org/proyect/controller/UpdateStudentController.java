package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.proyect.App;
import org.proyect.model.Student;
import org.proyect.services.StudentServicesImplement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateStudentController implements Initializable {
    @FXML
    private Label lblNu,lblCounseling, lblPsychology, lblMedical, lblSocial;
    @FXML
    private TextField txtNameStudent, txtGroup, txtGrade, txtTuition, txtTotalAverage, txtCanalization;
    @FXML
    private TextArea txtReasonForDisapproval;
    @FXML
    private StudentServicesImplement studentServicesImplement;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentServicesImplement = new StudentServicesImplement();
    }
    @FXML
    public void updateStudent(ActionEvent event) {
        studentServicesImplement.addStudent(new Student(txtTuition.getText(), txtNameStudent.getText(),
                txtReasonForDisapproval.getText(), Double.valueOf(txtTotalAverage.getText()), Boolean.valueOf(txtCanalization.getText()),
                txtGroup.getText(), Integer.valueOf(txtGrade.getText())));
    }
    public void setStudent(Student student, int n) {
        lblNu.setText("N."+n);
        txtNameStudent.setText(student.getNameStudent());
        txtGroup.setText(student.getGroup());
        txtGrade.setText(String.valueOf(student.getGrade()));
        txtTuition.setText(student.getTuition());
        txtTotalAverage.setText(String.valueOf(student.getTotalAverage()));
        txtCanalization.setText(String.valueOf(student.getCanalization()));
        lblCounseling.setText(validateAssistance(student.getAssistance().getAssistanceInAcademicCounseling()));
        lblPsychology.setText(validateAssistance(student.getAssistance().getPsychologyAssistance()));
        lblMedical.setText(validateAssistance(student.getAssistance().getMedicalServiceAssistance()));
        lblSocial.setText(validateAssistance(student.getAssistance().getAssistanceInSocialService()));
        txtReasonForDisapproval.setText(student.getReasonForDisapproval());
    }
    private String validateAssistance(String assistance) {
        return assistance == null ? "NO" :"SI";
    }

    public void profileStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = App.loadFXMlView("dialogStudent");
        Parent root = loader.load();
        DialogStudentController dialogStudentController = loader.getController();
        dialogStudentController.initCourses(txtTuition.getText(), txtNameStudent.getText());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
