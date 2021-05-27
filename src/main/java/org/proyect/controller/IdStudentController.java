package org.proyect.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.proyect.App;
import org.proyect.model.Student;
import org.proyect.services.AssistanceServicesImplement;
import org.proyect.services.StudentServicesImplement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IdStudentController implements Initializable {
    private StudentServicesImplement studentServicesImplement;
    private AssistanceServicesImplement assistanceServicesImplement;
    @FXML
    private TextField idStudent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentServicesImplement = new StudentServicesImplement();
        assistanceServicesImplement = new AssistanceServicesImplement();
    }
    @FXML
    public void showProfileStudent(ActionEvent event) throws IOException {
        Student student = studentServicesImplement.getByIdStudent(idStudent.getText());
        if(student == null)
            showAlertError(event);
        FXMLLoader loader = App.loadFXMlView("updateStudent");;
        Parent root = loader.load();
        UpdateStudentController updateStudent= loader.getController();
        student.setAssistance(assistanceServicesImplement.getByIdAssistance(idStudent.getText()));
        updateStudent.setStudent(student, 1);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
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
