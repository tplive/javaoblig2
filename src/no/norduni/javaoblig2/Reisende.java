/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

/**
 *
 * @author Thomas
 */
class Reisende implements java.io.Serializable {
	// Private variabler
	private String navn;
	private String kjonn;
	private int alder;
	private int passNo;
	private int gruppeKode;

	// Constructor metode
	public Reisende(String navn, String kjonn, int alder, int passNo, int gruppeKode) {
		this.navn = navn;
		this.kjonn = kjonn;
		this.alder = alder;
		this.passNo = passNo;
		this.gruppeKode = gruppeKode;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjønn(String kjonn) {
		if (kjonn == "M" || kjonn == "K") {
			this.kjonn = kjonn;
		}
	}

	public int getAlder() {
		return alder;
	}

	public void setAlder(int alder) {
		this.alder = alder;
	}

	public int getPassNo() {
		return passNo;
	}

	public void setPassNo(int passNo) {
		this.passNo = passNo;
	}

	public int getGruppeKode() {
		return gruppeKode;
	}

	public void setGruppeKode(int gruppeKode) {
		this.gruppeKode = gruppeKode;
	}

}
