package org.proyect.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.proyect.model.Assistance;
import org.proyect.model.Course;
import org.proyect.model.Student;
import org.proyect.services.CourseServicesImplement;
import org.proyect.services.StudentServicesImplement;
import org.proyect.services.AssistanceServicesImplement;

import java.net.URL;
import java.util.ResourceBundle;

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
    private Assistance assistance;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentServicesImplement = new StudentServicesImplement();
        assistanceServicesImplement = new AssistanceServicesImplement();
        courseServicesImplement = new CourseServicesImplement();
        assistance = new Assistance();
        loadCmb();
    }
    //idStudent, nameStudent, reasonForDisapproval, totalAverage, canalization, groupS, grade, idManager
    @FXML
    public void addStudent(ActionEvent event) {
        studentServicesImplement.addStudent(new Student(txtTuition.getText(), txtNameStudent.getText(),
                txtReasonForDisapproval.getText(), 70D, Boolean.valueOf(txtCanalization.getText()),
                String.valueOf(cmbGroup.getSelectionModel().getSelectedIndex()+1),
                cmbGrade.getSelectionModel().getSelectedIndex()+1, txtIdManager.getText()));
        getValueCheckBoxCourses();
        getValueCheckBoxAssists();
    }
    public void getValueCheckBoxAssists() {
        if(cbCounseling.isSelected()){
            assistance.setAssistanceInAcademicCounseling(cbCounseling.getText());
            assistanceServicesImplement.addAssistance(txtTuition.getText(), assistance.getAssistanceInAcademicCounseling());
        }
        if(cbPsychology.isSelected()){
            assistance.setPsychologyAssistance(cbPsychology.getText());
            assistanceServicesImplement.addAssistance(txtTuition.getText(), assistance.getPsychologyAssistance());
        }
        if(cbMedical.isSelected()) {
            assistance.setMedicalServiceAssistance(cbMedical.getText());
            assistanceServicesImplement.addAssistance(txtTuition.getText(), assistance.getMedicalServiceAssistance());
        }
        if(cbSocialService.isSelected())  {
            assistance.setAssistanceInSocialService(cbSocialService.getText());
            assistanceServicesImplement.addAssistance(txtTuition.getText(), assistance.getAssistanceInSocialService());
        }
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
