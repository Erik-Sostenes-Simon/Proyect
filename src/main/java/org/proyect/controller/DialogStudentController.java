package org.proyect.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.proyect.model.Course;
import org.proyect.services.CourseServicesImplement;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DialogStudentController implements Initializable {
    @FXML
    private GridPane gridCourses;
    @FXML
    private Label lblNameStudent;
    private CourseServicesImplement courseServicesImplement;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void initCourses(String idStudent, String nameStudent) {
        courseServicesImplement = new CourseServicesImplement();
        lblNameStudent.setText(nameStudent);
        List<Course> courses = courseServicesImplement.getByIdCourse(idStudent);
        byte key = 1;
        for(Course c : courses)
            gridCourses.addRow(key++, new Label(c.getIdCourse()),
                    new Label(c.getNameCourse()), new Label(c.getNameManager()),
                    new Label(c.getEvaluationUnit()+""),  new Label(c.getKeyGroup()),
                    new Label(c.getPeriodC()), new Label(c.getQualification()+""),
            new Label(c.getIdStudent()), new Label(c.getIdManager()));
    }
}
