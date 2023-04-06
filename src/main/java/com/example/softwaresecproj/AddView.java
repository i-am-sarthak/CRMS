package com.example.softwaresecproj;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddView extends GridPane{
    private static TextField recordField;
    private static DatePicker firDatePicker;
    private static TextField criminalIdField, crimeDescriptionField, addressField;
    private Button saveButton;

    public AddView(){
        setup();
        AddRecordController.addRecord(saveButton);
    }

    private void setup(){

        String labelColor = "-fx-text-fill: #ADEAEA;";

        Label nameLabel = new Label("Full Name");
        nameLabel.setStyle(labelColor);

        Label firDateLabel = new Label("Date of FIR");
        firDateLabel.setStyle(labelColor);

        Label criminalIdLabel = new Label("Criminal ID");
        criminalIdLabel.setStyle(labelColor);

        Label crimeDescriptionLabel = new Label("Crime Description");
        crimeDescriptionLabel.setStyle(labelColor);

        Label addressLabel = new Label("Address");
        addressLabel.setStyle(labelColor);

        recordField = new TextField();
        firDatePicker = new DatePicker();
        addressField = new TextField();
        criminalIdField = new TextField();
        crimeDescriptionField = new TextField();
        saveButton = new Button("Save");

        this.add(nameLabel, 0, 0);
        this.add(recordField, 1, 0);
        this.add(firDateLabel, 0, 1);
        this.add(firDatePicker, 1, 1);
        this.add(criminalIdLabel, 0, 2);
        this.add(criminalIdField, 1, 2);
        this.add(crimeDescriptionLabel, 0, 3);
        this.add(crimeDescriptionField, 1, 3);
        this.add(addressLabel,0,4);
        this.add(addressField,1,4);
        this.add(saveButton, 1, 5);

        this.setHgap(10);
        this.setVgap(10);
        this.setAlignment(Pos.CENTER);

    }

    public static TextField getCriminalIdField() {
        return criminalIdField;
    }

    public static TextField getAddressField() {
        return addressField;
    }

    public static TextField getRecordField() {
        return recordField;
    }

    public static DatePicker getFirDatePicker() {
        return firDatePicker;
    }

    public static TextField getCrimeDescriptionField() {
        return crimeDescriptionField;
    }
}
