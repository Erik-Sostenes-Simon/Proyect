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
    private Label txtNameStudent, txtGroup, txtGrade, txtTuition, txtTotalAverage, txtCanalization, txtNu;
    @FXML
    private TextArea txtReasonForDisapproval;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setStudent(Student student, int n) {
        txtNu.setText("N."+n);
        txtNameStudent.setText(student.getNameStudent());
        txtGroup.setText(student.getGroup());
        txtGrade.setText(String.valueOf(student.getGrade()));
        txtTuition.setText(student.getTuition());
        txtTotalAverage.setText(String.valueOf(student.getTotalAverage()));
        txtCanalization.setText(String.valueOf(student.getCanalization()));
        txtReasonForDisapproval.setText(student.getReasonForDisapproval());
    }
    public void editStudent(ActionEvent event) throws IOException {
        App.setRoot("dialogStudent");
    }
}
