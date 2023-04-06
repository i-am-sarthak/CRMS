package com.example.softwaresecproj;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.time.LocalDate;

public class AddRecordController {

    private AddRecordController() {
        // private constructor to prevent instances from being created
    }

    //click listener on button
    public static void addRecord(Button button) {
        button.setOnAction((ActionEvent e) -> {
            String recordFieldValue = AddView.getRecordField().getText();
            LocalDate firDatePickerValue = AddView.getFirDatePicker().getValue();
            String criminalIdFieldValue = AddView.getCriminalIdField().getText();
            String addressFieldValue = AddView.getAddressField().getText();
            String crimeDescriptionFieldValue = AddView.getCrimeDescriptionField().getText();

            boolean isRecordFieldEmpty = recordFieldValue.equals("");
            boolean isFirDatePickerNull = firDatePickerValue == null;
            boolean isCriminalIdFieldEmpty = criminalIdFieldValue.equals("");
            boolean isAddressFieldEmpty = addressFieldValue.equals("");
            boolean isCrimeDescriptionFieldEmpty = crimeDescriptionFieldValue.equals("");

            boolean hasEmptyFields = isRecordFieldEmpty || isCriminalIdFieldEmpty || isAddressFieldEmpty;
            boolean hasNullDate = isFirDatePickerNull;
            boolean hasEmptyDescription = isCrimeDescriptionFieldEmpty;
            if (hasEmptyFields || hasNullDate || hasEmptyDescription) {
                Main.showDialog("Please fill all the fields", 2);
            }else{
                Record record = new Record();
                record.setRecord(AddView.getRecordField().getText());
                record.setFirDate(AddView.getFirDatePicker().getValue().toString());
                record.setCriminalId(AddView.getCriminalIdField().getText());
                record.setCrimeDescription(AddView.getCrimeDescriptionField().getText());
                record.setAddress(AddView.getAddressField().getText());
                Main.records.add(record);
                Main.showDialog("Record added successfully", 1);
            }
        });
    }
}
