package com.example.softwaresecproj;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Record {
    public StringProperty record;
    private StringProperty FirDate;
    private StringProperty criminalId;
    private StringProperty crimeDescription;
    private StringProperty address;

    public Record(){
        this.record = new SimpleStringProperty();
        this.FirDate = new SimpleStringProperty();
        this.criminalId = new SimpleStringProperty();
        this.crimeDescription = new SimpleStringProperty();
        this.address = new SimpleStringProperty();

    }

    public String getRecord() {
        return record.get();
    }

    public StringProperty recordProperty() {
        return record;
    }

    public void setRecord(String record) {
        this.record.set(record);
    }

    public String getFirDate() {
        return FirDate.get();
    }

    public StringProperty firDateProperty() {
        return FirDate;
    }

    public void setFirDate(String firDate) {
        this.FirDate.set(firDate);
    }


    public String getCriminalId() {
        return criminalId.get();
    }

    public StringProperty criminalIdProperty() {
        return criminalId;
    }

    public void setCriminalId(String criminalId) {
        this.criminalId.set(criminalId);
    }

    public String getCrimeDescription() {
        return crimeDescription.get();
    }

    public StringProperty crimeDescriptionProperty() {
        return crimeDescription;
    }

    public void setCrimeDescription(String crimeDescription) {
        this.crimeDescription.set(crimeDescription);
    }

    //
    public String getAddress() { return address.get(); }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Record record1 = (Record) o;
        return Objects.equals(record, record1.record) &&
                Objects.equals(FirDate, record1.FirDate) &&
                Objects.equals(criminalId, record1.criminalId) &&
                Objects.equals(crimeDescription, record1.crimeDescription) &&
                Objects.equals(address, record1.address);
    }

}
