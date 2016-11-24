/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Eline
 */

public class Gruppe implements java.io.Serializable {

	private SimpleIntegerProperty gruppeKode;
	private SimpleStringProperty flightNo;

	public Gruppe() {
		this.gruppeKode = new SimpleIntegerProperty(0);
		this.flightNo = new SimpleStringProperty("");
	}

	public int getGruppeKode() {
		return gruppeKode.getValue();
	}

	public void setGruppeKode(int gruppeKode) {
		this.gruppeKode.setValue(gruppeKode);
	}

	public String getFlightNo() {
		return flightNo.getValue();
	}

	public void setFlightNo(String flightNo) {
		this.flightNo.setValue(flightNo);
	}

}
