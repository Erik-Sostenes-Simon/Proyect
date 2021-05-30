package org.proyect.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.proyect.model.Assistance;
import org.proyect.model.Course;
import org.proyect.model.Student;
import org.proyect.services.CourseServicesImplement;
import org.proyect.services.StudentServicesImplement;
import org.proyect.services.AssistanceServicesImplement;
import static java.lang.Math.round;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.Stack;

public class AddStudentController implements Initializable {
    @FXML
    private ComboBox<Integer> cmbGrade;
    @FXML
    private ComboBox<String> cmbGroup;
    @FXML
    private CheckBox cbPsychology, cbMedical, cbSocialService, cbCounseling;
    @FXML
    private CheckBox cbDatabase, cbElectronics, cbAdvancedTopics;
    @FXML
    private TextField txtTuition, txtNameStudent, txtCanalization, txtIdManager,
            txtDatabaseQualification, txtKeyGroup, txtIDDatabase, txtNManagerDatabase,
            txtUnitDatabase, txtPeriodDatabase, txtIdManagerDatabase;
    @FXML
    private TextField txtElectronicsQualification, txtIDElectronics, txtNManagerElectronics,
            txtPeriodElectronics, txtUnitElectronics, txtIdManagerElectronics;
    @FXML
    private TextField txtUnitAdvancedTopics, txtPeriodAdvancedTopics, txtIdManagerAdvancedTopics,
    txtNManagerAdvancedTopics, txtAdvancedTopicsQ, txtIDAdvancedTopics;
    @FXML
    private TextArea txtReasonForDisapproval;
    private ObservableList<Integer> itemsGrade;
    private ObservableList<String>  itemsGroup;
    private StudentServicesImplement studentServicesImplement;
    private CourseServicesImplement courseServicesImplement;
    private AssistanceServicesImplement assistanceServicesImplement;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentServicesImplement = new StudentServicesImplement();
        assistanceServicesImplement = new AssistanceServicesImplement();
        courseServicesImplement = new CourseServicesImplement();
        loadCmb();
    }
    public Double generalPrimed() {
        Double database = 0D;
        Double electronic = 0D;
        Double topics = 0D;
        if(!txtDatabaseQualification.getText().isBlank()) {
           database = Double.parseDouble(txtDatabaseQualification.getText());
        }
        if(!txtElectronicsQualification.getText().isBlank()) {
            electronic = Double.parseDouble(txtElectronicsQualification.getText());
        }
        if(!txtAdvancedTopicsQ.getText().isBlank()){
            topics = Double.parseDouble(txtAdvancedTopicsQ.getText());
        }
        return (database+electronic+topics) / 3;
    }
    //idStudent, nameStudent, reasonForDisapproval, totalAverage, canalization, groupS, grade, idManager
    @FXML
    public void addStudent(ActionEvent event) {
        Double totalQualification =  generalPrimed();
        studentServicesImplement.addStudent(new Student(txtTuition.getText(), txtNameStudent.getText(),
                txtReasonForDisapproval.getText(), totalQualification, Boolean.valueOf(txtCanalization.getText()),
                String.valueOf(cmbGroup.getSelectionModel().getSelectedIndex()+1),
                cmbGrade.getSelectionModel().getSelectedIndex()+1, txtIdManager.getText()));
        getValueCheckBoxCourses();
        getValueCheckBoxAssists();
        showAlertCreatedStudent(event);
    }
    @FXML
    private void showAlertCreatedStudent(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Exito");
        alert.setTitle("Info");
        alert.setContentText("Estudiante creado correctamente");
        alert.showAndWait();
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    public void getValueCheckBoxAssists() {
        if (!cbCounseling.isSelected()) cbCounseling.setText("");
        if (!cbPsychology.isSelected()) cbPsychology.setText("");
        if (!cbMedical.isSelected()) cbMedical.setText("");
        if (!cbSocialService.isSelected()) cbSocialService.setText("");
            assistanceServicesImplement.addAssistance(txtTuition.getText(), new Assistance(cbCounseling.getText(),
                    cbPsychology.getText(), cbMedical.getText(), cbSocialService.getText()));
    }
    public void getValueCheckBoxCourses() {
        if(cbDatabase.isSelected())
            courseServicesImplement.addCourse(txtTuition.getText(),
                    new Course(txtIDDatabase.getText(), cbDatabase.getText(), txtNManagerDatabase.getText(),
                            Integer.valueOf(txtUnitDatabase.getText()), txtKeyGroup.getText(),  txtPeriodDatabase.getText(),
                            Double.valueOf(txtDatabaseQualification.getText()), txtTuition.getText(), txtIdManagerDatabase.getText()));

        if(cbElectronics.isSelected())
            courseServicesImplement.addCourse(txtTuition.getText(),
                    new Course(txtIDElectronics.getText(), cbElectronics.getText(),txtNManagerElectronics.getText(),
                            Integer.valueOf(txtUnitElectronics.getText()), txtKeyGroup.getText(), txtPeriodElectronics.getText(),
                            Double.valueOf(txtElectronicsQualification.getText()), txtTuition.getText(), txtIdManagerElectronics.getText()));

        if(cbAdvancedTopics.isSelected())
            courseServicesImplement.addCourse(txtTuition.getText(),
                    new Course(txtIDAdvancedTopics.getText(), cbAdvancedTopics.getText(), txtNManagerAdvancedTopics.getText(),
                            Integer.valueOf(txtUnitAdvancedTopics.getText()), txtKeyGroup.getText(),txtPeriodAdvancedTopics.getText(),
                             Double.valueOf(txtAdvancedTopicsQ.getText()), txtTuition.getText(), txtIdManagerAdvancedTopics.getText()));
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
