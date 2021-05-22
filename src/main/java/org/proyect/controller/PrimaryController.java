package org.proyect.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import org.proyect.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("home");
    }
}
