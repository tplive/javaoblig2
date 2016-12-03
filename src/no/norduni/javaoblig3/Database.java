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
        try{
            dbConnection = DriverManager.getConnection(dbName);
            dbCreate();
        }catch (Exception ex) {
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
            ResultSet dbRS = dbMeta.getTables(null, "APP", "FLIGHT", null);
            if (!dbRS.next()) {
                System.out.println("Fant ikke tabell FLIGHT, burde nok opprette den..");
                
                String create = "CREATE TABLE FLIGHT(id integer primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), flightNo varchar(255), fraFlyplass varchar(255), tilFlyplass varchar(255), startTid varchar(255), reiseTid integer, antallSeter integer)";
                sqlSetning.execute(create);
            }else{
                System.out.println("Tabellen FLIGHT finnes allerede..");
            }
            
            dbRS = dbMeta.getTables(null, "APP", "REISENDE", null);
            if (!dbRS.next()) {
                System.out.println("Fant ikke tabell REISENDE, burde nok opprette den..");
                
                String create = "CREATE TABLE REISENDE(id integer primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), navn varchar(255), alder integer, kjonn varchar(255), passNo varchar(255), gruppeKode integer)";
                sqlSetning.execute(create);
            }else{
                System.out.println("Tabellen REISENDE finnes allerede..");
            }
            
            dbRS = dbMeta.getTables(null, "APP", "GRUPPER", null);
            if (!dbRS.next()) {
                System.out.println("Fant ikke tabell GRUPPER, burde nok opprette den..");
                
                String create = "CREATE TABLE GRUPPER(id integer primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), gruppeKode integer, flightNo varchar(255))";
                sqlSetning.execute(create);
            }else{
                System.out.println("Tabellen GRUPPER finnes allerede..");
            }
            
            dbRS = dbMeta.getTables(null, "APP", "BETALINGER", null);
            if (!dbRS.next()) {
                System.out.println("Fant ikke tabell BETALINGER, burde nok opprette den..");
                
                String create = "CREATE TABLE BETALINGER(id integer primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), personPassNo varchar(255), betalingsMaate varchar(255), summen decimal)";
                sqlSetning.execute(create);
            }else{
                System.out.println("Tabellen BETALINGER finnes allerede..");
            }
            
            
            
            
        }catch(Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "dbCreate: Kunne ikke finne databasedriveren");
        }
    }
    
    public Connection getConnection() {
        return dbConnection;
    } 
    
    // CRUD
    // Create, Read, Update, Delete; INSERT, SELECT, UPDATE, DELETE
    public ArrayList readAllFlights() {
        ArrayList flights = new ArrayList();
        return flights;

    }
    
    public Flight readFlight(String flightNo) {
        Flight flight = new Flight();
        return flight;
    }
    
    public void insertFlight(Flight flight) {
        
    }
    
}
