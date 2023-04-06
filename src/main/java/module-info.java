module com.example.softwaresecproj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.softwaresecproj to javafx.fxml;
    exports com.example.softwaresecproj;
}