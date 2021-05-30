package org.proyect.controller;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.proyect.App;
import org.proyect.model.Assistance;
import org.proyect.model.Student;
import org.proyect.services.StudentServicesImplement;
import org.proyect.services.AssistanceServicesImplement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.BiFunction;

public class HomeStudentsController implements Initializable {
    @FXML
    private TextField txtSearchStudent;
    @FXML
    private FileChooser fileChooser;
    @FXML
    private Label lblTotalStudents, lblGeneralPrimed, lblReproached, lblApproved;

    private StudentServicesImplement studentServicesImplement;
    private AssistanceServicesImplement assistanceServicesImplement;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assistanceServicesImplement = new AssistanceServicesImplement();
        fileChooser = new FileChooser();
        init();
    }
    public void init() {
        studentServicesImplement = new StudentServicesImplement();
        Double general = 0.0;
        Integer reproached = 0;
        Integer approved = 0;
        Map<Integer, Student> students =  studentServicesImplement.getAllStudent();
        lblTotalStudents.setText(students.size()+"");
        for (Map.Entry<Integer,Student> student : students.entrySet()) {
            general += student.getValue().getTotalAverage();
            if(student.getValue().getTotalAverage() < 70)
                reproached++;
            if(student.getValue().getTotalAverage() >= 70)
                approved++;
        }
        lblGeneralPrimed.setText(generalPrimed.apply(general, students.size())+"");
        lblApproved.setText(approved+"");
        lblReproached.setText(reproached+"");
    }
    static BiFunction<Double, Integer, Double> generalPrimed = (qualification, size) -> {
        return qualification / size;
    };
    @FXML
    public void initData(ActionEvent event) {
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
        stage.setResizable(false);
        stage.showAndWait();
        txtSearchStudent.setText("");
    }
    @FXML
    public void update(ActionEvent event) throws IOException {
        App.setRoot("allStudents");
    }
    @FXML
    public void generatePDF(ActionEvent event) {
        Map<Integer, Student> students = studentServicesImplement.getAllStudent();
        Assistance assistance = null;
        StringBuilder str = new StringBuilder();
        str.append("key").append(",").append("Matricula").append(",").append("NombreEstudiante").append(",").append(" RasonPorReprovar")
        .append(",").append("TotalPromedio").append(",").append("Canalización").append(",").append("Grupo").append(",").append("Grado")
                .append(",").append("IdProfesor").append(",").append("AsistenciaEnConsejeríaAcadémica").append(",").append("PsicologíaAsistencia")
        .append(",").append("AsistenciaServicioSocial").append(",").append("AsistenciaMédica").append("\n");
        for (Map.Entry<Integer,Student> entry : students.entrySet()) {
            str.append(entry.getKey()).append(",").append(entry.getValue());
            assistance = assistanceServicesImplement.getByIdAssistance(entry.getValue().getTuition());
            str.append(",").append(assistance.getAssistanceInAcademicCounseling()).append(",").append(assistance.getPsychologyAssistance())
                    .append(",").append(assistance.getAssistanceInSocialService()).append(",").append(assistance.getMedicalServiceAssistance()).append("\n");
        }
        File file = fileChooser.showSaveDialog(new Stage());
        saveSystem(file, str);
    }
    public void saveSystem(File file, StringBuilder content) {
        try{
            PrintWriter printWriter = new PrintWriter(file);

            printWriter.write(content.toString());
            printWriter.close();
        }catch(FileNotFoundException e) {

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