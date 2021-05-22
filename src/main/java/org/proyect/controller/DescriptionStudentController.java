package org.proyect.controller;

import javafx.event.ActionEvent;
import org.proyect.App;

import java.io.IOException;

public class DescriptionStudentController {

    public void showProfile(ActionEvent event) throws IOException {
        App.setRoot("dialogStudent");
    }
}
