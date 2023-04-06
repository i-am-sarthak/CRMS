package com.example.softwaresecproj;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class RootView {
    private static BorderPane root;
//    private MenuBar menuBar;
//    private Menu file;
    private MenuItem addRecord;
    private MenuItem listRecord;
    private MenuItem exit;
//    private Menu help;
    private MenuItem about;


    public RootView(){
        setup();
        RootController.addRecord(addRecord);
        RootController.listRecords(listRecord);
        RootController.exitProgram(exit);
        RootController.about(about);
    }

    private void setup(){
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("Menu");
        addRecord = new MenuItem("Add Record");
        listRecord = new MenuItem("List Records");
        exit = new MenuItem("Exit");
        Menu help = new Menu("Help");
        about = new MenuItem("About");

        Label homeScreenLabel = new Label("Welcome to Criminal Record Management System\n" +
                "\nEasily access and organize criminal records and maintain confidentiality with the secure interface.\n" +
                "\nPlease select an option from the menu");
        homeScreenLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 20px; -fx-text-fill: #ADEAEA");
        homeScreenLabel.setPrefWidth(500);
        homeScreenLabel.setWrapText(true);


        file.getItems().addAll(addRecord, listRecord, exit);
        help.getItems().add(about);
        menuBar.getMenus().addAll(file, help);

        root = new BorderPane();
        root.setCenter(homeScreenLabel);
        root.setTop(menuBar);
        root.setStyle("-fx-background-color: #3A3A38");
    }

    public static BorderPane getRoot() {
        return root;
    }
}
