package com.example.softwaresecproj;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;

public class SplashScreen extends javafx.scene.layout.BorderPane {

    public SplashScreen() {
        javafx.scene.control.Label label = new javafx.scene.control.Label("Loading...");
        label.setFont(new javafx.scene.text.Font(20));
        label.setStyle("-fx-text-fill: #ADEAEA");
        this.setCenter(label);
        this.setStyle("-fx-background-color: #3A3A38");

        FadeTransition fadeIn = new FadeTransition(javafx.util.Duration.seconds(3), label);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        FadeTransition fadeOut = new FadeTransition(javafx.util.Duration.seconds(3), label);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        fadeIn.play();

        fadeIn.setOnFinished((e) -> fadeOut.play());

        fadeOut.setOnFinished((e) -> {
            javafx.stage.Stage stage = (javafx.stage.Stage) this.getScene().getWindow();
            RootView root = new RootView();

            stage.setScene(new Scene(root.getRoot(), 600, 400));
        });
    }


}
