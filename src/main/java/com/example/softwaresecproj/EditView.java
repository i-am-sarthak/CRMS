package com.example.softwaresecproj;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class EditView extends GridPane {
    private static TextField recordField;
    private static DatePicker firDatePicker;
    private static TextField criminalIdField, crimeDescriptionField, addressField;
    private Button saveButton;

    public EditView(){
        setup();
        EditRecordController.editRecord(saveButton);
    }
    private void setup(){

        String labelColor = "-fx-text-fill: #ADEAEA;";


        Label recordLabel = new Label("Record");
        recordLabel.setStyle(labelColor);
        Label firDateLabel = new Label("FIR Date");
        firDateLabel.setStyle(labelColor);
        Label criminalIdLabel = new Label("Criminal ID");
        criminalIdLabel.setStyle(labelColor);
        Label crimeDescriptionLabel = new Label("Crime Description");
        crimeDescriptionLabel.setStyle(labelColor);
        Label addressLabel = new Label("Address");
        addressLabel.setStyle(labelColor);
        recordField = new TextField(ListRecordController.selectedRecord.getRecord());
        firDatePicker = new DatePicker();
        LocalDate firDate = LocalDate.parse(ListRecordController.selectedRecord.getFirDate());
        firDatePicker.setValue(firDate);
        criminalIdField = new TextField(ListRecordController.selectedRecord.getCriminalId());
        crimeDescriptionField = new TextField(ListRecordController.selectedRecord.getCrimeDescription());
        addressField = new TextField(ListRecordController.selectedRecord.getAddress());
        saveButton = new Button("Update");

        this.add(recordLabel, 0, 0);
        this.add(recordField, 1, 0);
        this.add(firDateLabel, 0, 1);
        this.add(firDatePicker, 1, 1);
        this.add(criminalIdLabel, 0, 3);
        this.add(criminalIdField, 1, 3);
        this.add(crimeDescriptionLabel, 0, 4);
        this.add(crimeDescriptionField, 1, 4);
        this.add(addressLabel, 0, 5);
        this.add(addressField,1,5);
        this.add(saveButton, 1, 6);

        this.setHgap(10);
        this.setVgap(10);
        this.setAlignment(Pos.CENTER);
    }

    public static TextField getRecordField() {
        return recordField;
    }

    public static DatePicker getFirDatePicker() {
        return firDatePicker;
    }

    public static TextField getCriminalIdField() {
        return criminalIdField;
    }

    public static TextField getCrimeDescriptionField() {
        return crimeDescriptionField;
    }

//    public Label getCrimeDescriptionLabel() {
//        return crimeDescriptionLabel;
//    }

    public static TextField getAddressField() {
        return addressField;
    }

}
