package com.example.softwaresecproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ListRecordController {
    public static Record selectedRecord;
    //delete action
    public static void deleteRecord(Button button) {
        button.setOnAction((ActionEvent e) -> {
            if(ListView.getRecordTable().getSelectionModel().getSelectedItem() == null) {
                Main.showDialog("Please select a record to delete", 2);
            }else{
                Main.records.remove(ListView.getRecordTable().getSelectionModel().getSelectedItem());
                ObservableList<Record> records = FXCollections.observableArrayList();
                records.addAll(Main.records);
                ListView.setupData(records);
                Main.showDialog("Record deleted successfully", 1);
            }
        });
    }
    public static void editRecord(Button button) {
        button.setOnAction((ActionEvent e) -> {
            if(ListView.getRecordTable().getSelectionModel().getSelectedItem() == null) {
                Main.showDialog("Please select a record to edit", 2);
            }else{
                selectedRecord = ListView.getRecordTable().getSelectionModel().getSelectedItem();
                RootView.getRoot().setCenter(new EditView());
            }
        });
    }
}
