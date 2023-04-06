package com.example.softwaresecproj;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

public class RootController {
    //click listener on menuItem
    public static void addRecord(MenuItem item) {
        item.setOnAction((ActionEvent e) -> {
            RootView.getRoot().setCenter(new AddView());
        });
    }
    public static void listRecords(MenuItem item) {
        item.setOnAction((ActionEvent e) -> {
            RootView.getRoot().setCenter(new ListView());
        });
    }

    public static void about(MenuItem item) {
        item.setOnAction((ActionEvent e) -> {
            RootView.getRoot().setCenter(new AboutView());
        });
    }
    public static void exitProgram(MenuItem item) {
        item.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
    }
}
