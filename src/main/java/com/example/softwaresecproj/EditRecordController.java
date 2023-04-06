package com.example.softwaresecproj;

import javafx.scene.control.Button;

public class EditRecordController {
    public static void editRecord(Button button) {
        button.setOnAction((action) -> {
            if (ListRecordController.selectedRecord != null) {
                Main.records.remove(ListRecordController.selectedRecord);
                ListRecordController.selectedRecord = null;
//                System.out.println(Main.records.size());
                if (EditView.getRecordField().getText().equals("") ||
                        EditView.getFirDatePicker().getValue() == null ||
                        EditView.getCriminalIdField().getText().equals("") ||
                        EditView.getAddressField().getText().equals("") ||
                        EditView.getCrimeDescriptionField().getText().equals("")) {
                    Main.showDialog("Please fill all the fields", 2);
                } else {
                    Record record = new Record();
                    record.setRecord(EditView.getRecordField().getText());
                    record.setFirDate(EditView.getFirDatePicker().getValue().toString());
                    record.setCriminalId(EditView.getCriminalIdField().getText());
                    record.setCrimeDescription(EditView.getCrimeDescriptionField().getText());
                    record.setAddress(EditView.getAddressField().getText());
                    Main.records.add(record);
                    Main.showDialog("Record updated successfully", 1);
                    RootView.getRoot().setCenter(new ListView());
                }
            } else {
                Main.showDialog("Please select a record to edit", 2);
                RootView.getRoot().setCenter(new ListView());
            }
        });
    }
}
