/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig3;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thomas
 */
public class Database {

    String dbName = "jdbc:derby://localhost:1527/oblig3_190395_285617;create=true";
    protected Connection dbConnection;

    public Database() {
        try {
            dbConnection = DriverManager.getConnection(dbName);
            dbCreate();
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Constructor: Kunne ikke finne databasedriveren");

        }
    }

    public void dbCreate() throws SQLException {
        Statement sqlSetning = null;
        try {
            System.out.println("Try");
            DatabaseMetaData dbMeta = dbConnection.getMetaData();
            sqlSetning = dbConnection.createStatement();
            ResultSet dbRS = dbMeta.getTables(null, "APP", "FLIGHTS", null);
            if (!dbRS.next()) {
                System.out.println("Fant ikke tabell FLIGHTS, burde nok opprette den..");

                String create = "CREATE TABLE FLIGHTS(id integer primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), flightNo varchar(255), fraFlyplass varchar(255), tilFlyplass varchar(255), startTid varchar(255), reiseTid integer, antallSeter integer)";
                sqlSetning.execute(create);
            } else {
                System.out.println("Tabellen FLIGHTS finnes allerede..");
            }

            dbRS = dbMeta.getTables(null, "APP", "REISENDE", null);
            if (!dbRS.next()) {
                System.out.println("Fant ikke tabell REISENDE, burde nok opprette den..");

                String create = "CREATE TABLE REISENDE(id integer primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), navn varchar(255), alder integer, kjonn varchar(255), passNo varchar(255), gruppeKode integer)";
                sqlSetning.execute(create);
            } else {
                System.out.println("Tabellen REISENDE finnes allerede..");
            }

            dbRS = dbMeta.getTables(null, "APP", "GRUPPER", null);
            if (!dbRS.next()) {
                System.out.println("Fant ikke tabell GRUPPER, burde nok opprette den..");

                String create = "CREATE TABLE GRUPPER(id integer primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), gruppeKode integer, flightNo varchar(255))";
                sqlSetning.execute(create);
            } else {
                System.out.println("Tabellen GRUPPER finnes allerede..");
            }

            dbRS = dbMeta.getTables(null, "APP", "BETALINGER", null);
            if (!dbRS.next()) {
                System.out.println("Fant ikke tabell BETALINGER, burde nok opprette den..");

                String create = "CREATE TABLE BETALINGER(id integer primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), personPassNo varchar(255), betalingsMaate varchar(255), summen decimal)";
                sqlSetning.execute(create);
            } else {
                System.out.println("Tabellen BETALINGER finnes allerede..");
            }

        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "dbCreate: Kunne ikke finne databasedriveren");
        }
    }

    public Connection getConnection() {
        return dbConnection;
    }

    // CRUD
    // Create, Read, Update, Delete; INSERT, SELECT, UPDATE, DELETE
    public ArrayList<Flight> readAllFlights() throws SQLException {

        Flight flight = new Flight();
        ArrayList<Flight> flights = new ArrayList<Flight>();

        PreparedStatement sqlQuery = dbConnection.prepareStatement("SELECT * FROM Flights");
        ResultSet result = sqlQuery.executeQuery();

        
            while (result.next()) {
                System.out.println(result.getString("FlightNo"));
                flight.setFlightNo(result.getString("FlightNo"));
                flight.setFraFlyplass(result.getString("fraFlyplass"));
                flight.setTilFlyplass(result.getString("tilFlyplass"));
                flight.setReiseTid(result.getInt("reiseTid"));
                flight.setStartTid(result.getString("startTid"));
                flight.setAntallSeter(result.getInt("antallSeter"));
                flights.add(flight);
            }
        
        return flights;

    }

    public ArrayList<Reisende> readAllReisende() throws SQLException {

        Reisende reisende = new Reisende();
        ArrayList<Reisende> passasjerListe = new ArrayList<Reisende>();

        PreparedStatement sqlQuery = dbConnection.prepareStatement("SELECT * FROM Reisende");
        ResultSet result = sqlQuery.executeQuery();

        if (result.next()) {
            while (result.next()) {
                reisende.setNavn(result.getString("navn"));
                reisende.setAlder(result.getInt("alder"));
                reisende.setKjonn(result.getString("kjonn"));
                reisende.setPassNo(result.getString("passNo"));
                reisende.setGruppeKode(result.getInt("gruppeKode"));
                passasjerListe.add(reisende);
                
            }
        }
        return passasjerListe;
    }

    public ArrayList<Gruppe> readAllGrupper() throws SQLException {

        Gruppe gruppe = new Gruppe();
        ArrayList<Gruppe> grupper = new ArrayList<Gruppe>();

        PreparedStatement sqlQuery = dbConnection.prepareStatement("SELECT * FROM Grupper");
        ResultSet result = sqlQuery.executeQuery();

        if (result.next()) {
            while (result.next()) {
                gruppe.setFlightNo(result.getString("flightNo"));
                gruppe.setGruppeKode(result.getInt("gruppeKode"));
                grupper.add(gruppe);
            }
        }
        return grupper;
    }

    public ArrayList<Betaling> readAllBetalinger() throws SQLException {

        Betaling betaling = new Betaling();
        ArrayList<Betaling> betalinger = new ArrayList<Betaling>();

        PreparedStatement sqlQuery = dbConnection.prepareStatement("SELECT * FROM Betalinger");
        ResultSet result = sqlQuery.executeQuery();

        if (result.next()) {
            while (result.next()) {
                System.out.println(result.getString("personPassNo"));
                betaling.setPersonPassNo(result.getString("personPassNo"));
                betaling.setBetalingsMaate(result.getInt("betalingsmaate"));
                betaling.setSum(result.getFloat("Summen"));
                betalinger.add(betaling);
            }
        }
        return betalinger;
    }

    public Flight readFlight(String flightNo) {
        Flight flight = new Flight();
        return flight;
    }

    public void insertFlight(Flight flight) throws SQLException {

        PreparedStatement sqlQuery = dbConnection.prepareStatement("INSERT INTO Flights (FlightNo, tilFlyplass, FraFlyplass, reiseTid, startTid, antallSeter) VALUES (?, ?, ?, ?, ?, ?)");
        sqlQuery.setString(1, flight.getFlightNo());
        sqlQuery.setString(2, flight.getFraFlyplass());
        sqlQuery.setString(3, flight.getTilFlyplass());
        sqlQuery.setInt(4, flight.getReiseTid());
        sqlQuery.setString(5, flight.getStartTid());
        sqlQuery.setInt(6, flight.getAntallSeter());

        sqlQuery.execute();

    }

    public void insertBetaling(Betaling betaling) throws SQLException {

        PreparedStatement sqlQuery = dbConnection.prepareStatement("INSERT INTO Betalinger (personpassno, betalingsmaate, summen) VALUES (?, ?, ?)");
        sqlQuery.setString(1, betaling.getPersonPassNo());
        sqlQuery.setInt(2, betaling.getBetalingsMaate());
        sqlQuery.setDouble(3, betaling.getSum());

        sqlQuery.execute();

    }

    public void insertGruppe(Gruppe gruppe) throws SQLException {
                PreparedStatement sqlQuery = dbConnection.prepareStatement("INSERT INTO Betalinger (flightno, gruppekode) VALUES (?, ?)");
        sqlQuery.setString(1, gruppe.getFlightNo());
        sqlQuery.setInt(2, gruppe.getGruppeKode());

        sqlQuery.execute();
        
    }

    public void insertReisende(Reisende reisende) throws SQLException {
        
        PreparedStatement sqlQuery = dbConnection.prepareStatement("INSERT INTO REISENDE (navn, alder, kjonn, passno, gruppekode) VALUES (?, ?, ?, ?, ?)");
        sqlQuery.setString(1, reisende.getNavn());
        sqlQuery.setInt(2, reisende.getAlder());
        sqlQuery.setString(3, reisende.getKjonn());
        sqlQuery.setString(4, reisende.getPassNo());
        sqlQuery.setInt(5, reisende.getGruppeKode());

        sqlQuery.execute();

    }

}
