/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Thomas
 */
public class Flight implements java.io.Serializable {

    // Private variabler
    private SimpleStringProperty flightNo;
    private SimpleStringProperty fraFlyplass;
    private SimpleStringProperty tilFlyplass;
    private SimpleStringProperty startTid;
    private SimpleIntegerProperty reiseTid ;
    private SimpleIntegerProperty antallSeter;

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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(makeWritableObject());
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ArrayList o = (ArrayList) in.readObject();
             
        this.flightNo = new SimpleStringProperty((String) o.get(0));
        this.fraFlyplass = new SimpleStringProperty((String) o.get(1));
        this.tilFlyplass = new SimpleStringProperty((String) o.get(2));
        this.reiseTid = new SimpleIntegerProperty((int) o.get(3));
        this.startTid = new SimpleStringProperty((String) o.get(4));
        this.antallSeter = new SimpleIntegerProperty((int) o.get(5));
    }    
}
