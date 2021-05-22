module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens org.proyect to javafx.fxml;
    exports org.proyect;
    exports org.proyect.controller;
    opens org.proyect.controller to javafx.fxml;
}