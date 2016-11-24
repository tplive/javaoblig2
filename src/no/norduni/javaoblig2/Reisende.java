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
 * @author Thomas
 */
public class Reisende implements java.io.Serializable  {
	// Private variabler
	private final SimpleStringProperty navn;
	private final SimpleStringProperty kjonn;
	private final SimpleIntegerProperty alder;
	private final SimpleStringProperty passNo;
	private final SimpleIntegerProperty gruppeKode;

	// Constructor metode
	public Reisende() {
            this.navn = new SimpleStringProperty("");
            this.kjonn = new SimpleStringProperty("");
            this.alder = new SimpleIntegerProperty(0);
            this.passNo = new SimpleStringProperty("");
            this.gruppeKode = new SimpleIntegerProperty(0);
            
	}

	public String getNavn() {
		return navn.getValue();
	}

	public void setNavn(String navn) {
		this.navn.setValue(navn);
	}

	public String getKjonn() {
		return kjonn.getValue();
	}

	public void setKjonn(String kjonn) {
		if (kjonn == "M" || kjonn == "K") {
			this.kjonn.setValue(kjonn);
		}
	}

	public int getAlder() {
		return alder.getValue();
	}

	public void setAlder(int alder) {
		this.alder.setValue(alder);
	}

	public String getPassNo() {
		return passNo.getValue();
	}

	public void setPassNo(String passNo) {
		this.passNo.setValue(passNo);
	}

	public int getGruppeKode() {
		return gruppeKode.getValue();
	}

	public void setGruppeKode(int gruppeKode) {
		this.gruppeKode.setValue(gruppeKode);
	}

}
