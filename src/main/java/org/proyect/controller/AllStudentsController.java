package org.proyect.controller;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import org.proyect.App;
import org.proyect.model.Student;
import org.proyect.services.StudentServicesImplement;
import org.proyect.services.AssistanceServicesImplement;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class AllStudentsController implements Initializable {
    @FXML
    private VBox vbxItemStudent;


    private static Scene scene;
    private StudentServicesImplement studentServicesImplement;
    private AssistanceServicesImplement assistanceServicesImplement;
    private Map<Integer, Student> student;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ActionEvent e = null;
        studentServicesImplement = new StudentServicesImplement();
        assistanceServicesImplement = new AssistanceServicesImplement();
        update(e);
    }

    public void searchStudent(ActionEvent event) throws IOException {
        App.setRoot("dialogStudent");
    }
    @FXML
    public void update(ActionEvent event) {
        student = studentServicesImplement.getAllStudent();

        FXMLLoader fxmlLoader = null;
        try {
            for (int i = 1; i <= student.size(); i++) {
                fxmlLoader = App.loadFXMlView("student");
                VBox sectionVBOX = fxmlLoader.load();
                StudentController studentController = fxmlLoader.getController();
                student.get(i).setAssistance(assistanceServicesImplement.getByIdAssistance(student.get(i).getTuition()));
                studentController.setStudent(student.get(i), i);
                vbxItemStudent.getChildren().add(sectionVBOX);
                student.get(i).getAssistance().setAssistanceInSocialService("");
                student.get(i).getAssistance().setPsychologyAssistance("");
                student.get(i).getAssistance().setAssistanceInAcademicCounseling("");
                student.get(i).getAssistance().setMedicalServiceAssistance("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}