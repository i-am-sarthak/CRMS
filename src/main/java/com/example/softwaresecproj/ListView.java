package com.example.softwaresecproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;


public class ListView extends GridPane {
    private static TableView<Record> tableView;
    private static TableColumn<Record, String> recordColumn;
    private static TableColumn<Record, String> firDateColumn;
    private static TableColumn<Record, String> criminalIdColumn;
    private static TableColumn<Record, String> crimeDescriptionColumn;
    private static TableColumn<Record, String> addressColumn;

    private Button deleteButton,editButton;

    public ListView(){
        setup();
        ListRecordController.deleteRecord(deleteButton);
        ListRecordController.editRecord(editButton);
    }
    private void setup(){
        tableView = new TableView<>();
        criminalIdColumn = new TableColumn<>("Criminal ID");
        recordColumn = new TableColumn<>("Full Name");
        firDateColumn = new TableColumn<>("Date of FIR");
        crimeDescriptionColumn = new TableColumn<>("Crime Description");
        addressColumn = new TableColumn<>("Address");
        deleteButton = new Button("Delete");
        editButton = new Button("Edit");

        tableView.getColumns().addAll(criminalIdColumn, recordColumn, firDateColumn, crimeDescriptionColumn, addressColumn);

        //add data in table
        ObservableList<Record> records = FXCollections.observableArrayList();
        records.addAll(Main.records);
        setupData(records);

        this.add(tableView, 0, 0);
        this.add(deleteButton, 0, 1);
        this.add(editButton, 1, 1);
        this.setHgap(10);
        this.setVgap(10);

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setAlignment(Pos.CENTER);
    }

    public static void setupData(ObservableList<Record> records) {
        ListView.recordColumn.setCellValueFactory(new PropertyValueFactory<>("record"));
        ListView.firDateColumn.setCellValueFactory(new PropertyValueFactory<>("firDate"));
        ListView.criminalIdColumn.setCellValueFactory(new PropertyValueFactory<>("criminalId"));
        ListView.crimeDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("crimeDescription"));
        ListView.addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        tableView.setItems(records);
    }

    public static TableView<Record> getRecordTable() {
        return tableView;
    }
}
