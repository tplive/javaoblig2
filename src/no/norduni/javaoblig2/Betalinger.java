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
public class Betalinger implements java.io.Serializable {
	
        public Betalinger() {

        }
	
	public int getPersonPassNo() {
		return personPassNo;
	}

	public void setPersonPassNo(int personPassNo) {
		this.personPassNo = personPassNo;
	}

	public int getBetalingsMaate() {
		return betalingsMaate;
	}

	public void setBetalingsMaate(int betalingsMaate) {
		// Betalingsmåter er:
		// 0 = cash kontant
		// 1 = kredittkort
		// 2 = reservert for fremtidig bruk
		this.betalingsMaate = betalingsMaate;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	private int personPassNo;
	private int betalingsMaate;
	private double sum;
}
