package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AllStudents implements Initializable {
    private static Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void searchStudent(ActionEvent event) throws IOException {
        setRoot("dialogStudent");
    }
    static void setRoot(String windows) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(loadFXML(windows)));
        stage.showAndWait();
    }
    private static Parent loadFXML(String view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(view + ".fxml"));
        return fxmlLoader.load();
    }
}