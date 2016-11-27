/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Thomas
 */
public class Flight implements java.io.Serializable {

    // Private variabler
    private final SimpleStringProperty flightNo;
    private final SimpleStringProperty fraFlyplass;
    private final SimpleStringProperty tilFlyplass;
    private final SimpleStringProperty startTid;
    private final SimpleIntegerProperty reiseTid;
    private final SimpleIntegerProperty antallSeter;

    // Constructor
    public Flight() {
        this.flightNo = new SimpleStringProperty("");
        this.fraFlyplass = new SimpleStringProperty("");
        this.tilFlyplass = new SimpleStringProperty("");
        this.startTid = new SimpleStringProperty("");
        this.reiseTid = new SimpleIntegerProperty(0);
        this.antallSeter = new SimpleIntegerProperty(0);
    }

    public String getFlightNo() {
        return flightNo.getValue();
    }

    public void setFlightNo(String flightNo) {
        this.flightNo.setValue(flightNo);
    }

    public String getFraFlyplass() {
        return fraFlyplass.getValue();
    }

    public void setFraFlyplass(String fraFlyplass) {
        this.fraFlyplass.setValue(fraFlyplass);
    }

    public String getTilFlyplass() {
        return tilFlyplass.getValue();
    }

    public void setTilFlyplass(String tilFlyplass) {
        this.tilFlyplass.setValue(tilFlyplass);
    }

    public String getStartTid() {
        return startTid.getValue();
    }

    public void setStartTid(String startTid) {
        this.startTid.setValue(startTid);
    }

    public int getReiseTid() {
        return reiseTid.getValue();
    }

    public void setReiseTid(int reiseTidMinutter) {
        this.reiseTid.setValue(reiseTidMinutter);
    }

    public int getAntallSeter() {
        return antallSeter.getValue();
    }

    public void setAntallSeter(int antallSeter) {
        this.antallSeter.setValue(antallSeter);
    }
    
    public ArrayList makeWritableObject() {
        ArrayList writableObject = new ArrayList();
        
        writableObject.add(this.flightNo.get());
        writableObject.add(this.fraFlyplass.get());
        writableObject.add(this.tilFlyplass.get());
        writableObject.add(this.reiseTid.get());
        writableObject.add(this.startTid.get());
        writableObject.add(this.antallSeter.get());
        
        return writableObject;
    }

}
