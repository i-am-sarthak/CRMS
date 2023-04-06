package com.example.softwaresecproj;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main extends Application {
    String username;
    String passwordHash;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static List<Record> records = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        readFromFile();
        // create login page
        Label usernameLbl = new Label("Username:");
        usernameLbl.setStyle("-fx-text-fill: #ADEAEA;");
        TextField usernameFld = new TextField();
        Label passwordLbl = new Label("Password:");
        passwordLbl.setStyle("-fx-text-fill: #ADEAEA;");
        PasswordField passwordFld = new PasswordField();
        Button loginBtn = new Button("Login");


        loginBtn.setOnAction(event -> {
            String usernameInp = usernameFld.getText();
            String passwordHashInp = hashPassword(passwordFld.getText());
//            System.out.println("hashedPassword============="+passwordHashInp);

            if (usernameInp.equals(username) && passwordHashInp.equals(passwordHash)) {
                showMainPage(stage);
            } else {
                showDialog("Invalid username or password", 2);
            }
        });
        HBox buttons = new HBox(loginBtn);
        VBox loginPane = new VBox(usernameLbl, usernameFld, passwordLbl, passwordFld, buttons);
        loginPane.setSpacing(10);
        loginPane.setStyle("-fx-padding: 20px; -fx-background-color: #3A3A38");
        Scene loginScene = new Scene(loginPane, 400, 200);

        // show login page
        stage.setTitle("Criminal Record Management System - Login");
        stage.setScene(loginScene);
        stage.show();
    }

    private void showMainPage(Stage stage) {
        // set scene to SplashScreen after successful login
        stage.setScene(new Scene(new SplashScreen(), 400, 300));
    }

    public static void showDialog(String msg, int type) {
        Alert alert;
        if (type == 1) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Information");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
        }
        alert.setTitle("Alert");
        alert.setContentText(msg);
        alert.show();
    }


    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.SEVERE, "Unable to hash password", e);
        }
        return null;
    }


    private void readFromFile() {
        File file = new File("credentials.txt");
        if (file.exists()) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                if (lines.size() >= 2) {
                    username = lines.get(0);
                    passwordHash = lines.get(1);
//                    System.out.println("Username========" + username);
//                    System.out.println("Password========" + passwordHash);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
