package org.proyect.controller;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    @FXML
    private TextField txtSearchStudent;


    private static Scene scene;
    private StudentServicesImplement studentServicesImplement;
    private AssistanceServicesImplement assistanceServicesImplement;
    private Map<Integer, Student> student;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ActionEvent e = null;
        studentServicesImplement = new StudentServicesImplement();
        assistanceServicesImplement = new AssistanceServicesImplement();
        init();
    }

    public void searchStudent(ActionEvent event) throws IOException {
        Student student = studentServicesImplement.getByIdStudent(txtSearchStudent.getText());
        if(student == null)
            showAlertError(event);
        FXMLLoader loader = App.loadFXMlView("student");;
        Parent root = loader.load();
        StudentController studentController = loader.getController();
        student.setAssistance(assistanceServicesImplement.getByIdAssistance(txtSearchStudent.getText()));
        studentController.setStudent(student, 1);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
        txtSearchStudent.setText("");
    }
    @FXML
    public void update(ActionEvent event) throws IOException {
        App.setRoot("homeStudents");
    }
    @FXML
    public void generatePDF(ActionEvent event) {
        System.out.println("Generar pdf");
    }
    public void init() {
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
    @FXML
    private void showAlertError(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("No existe el estudiante");
        alert.showAndWait();
    }
}