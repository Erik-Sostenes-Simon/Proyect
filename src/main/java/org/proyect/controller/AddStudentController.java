package org.proyect.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.proyect.model.Student;
import org.proyect.services.StudentServicesImplement;

import java.net.URL;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {
    @FXML
    private ComboBox<Integer> cmbGrade;
    @FXML
    private ComboBox<String> cmbGroup;
    @FXML
    private TextField txtTuition, txtNameStudent, txtCanalization, txtIdManager;
    @FXML
    private TextArea txtReasonForDisapproval;
    private ObservableList<Integer> itemsGrade;
    private ObservableList<String>  itemsGroup;
    private StudentServicesImplement studentServicesImplement;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentServicesImplement = new StudentServicesImplement();
        loadCmb();
    }
    //idStudent | nameStudent | reasonForDisapproval  | totalAvarage | canalization | groupS | grade | idManager
    @FXML
    public void addStudent(ActionEvent event) {
        studentServicesImplement.addStudent(new Student(txtTuition.getText(), txtNameStudent.getText(), txtReasonForDisapproval.getText(), 70D, Boolean.valueOf(txtCanalization.getText()),
                String.valueOf(cmbGroup.getSelectionModel().getSelectedIndex()+1), cmbGrade.getSelectionModel().getSelectedIndex()+1, txtIdManager.getText()));
    }
    public void loadCmb() {
        itemsGrade = FXCollections.observableArrayList();
        itemsGroup = FXCollections.observableArrayList();
        itemsGrade.addAll(1, 2, 3, 4, 5, 6, 7);
        itemsGroup.addAll("A", "B", "C");
        cmbGrade.setItems(itemsGrade);
        cmbGroup.setItems(itemsGroup);
    }
}
