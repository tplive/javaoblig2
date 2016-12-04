/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Thomas og Eline
 *
 *
 */
public class FXMLMainDocumentController implements Initializable {

    // Vi lagrer data binært i denne filen:
    String dataFile = "dataFile.txt";

    @FXML
    private TableView tblViewFlights;
    @FXML
    private TableView tblViewReisende;
    @FXML
    private TableView tblViewGrupper;
    @FXML
    private TableView tblViewBetalinger;

    // Lag lister som kan brukes i GUI
    ObservableList<Flight> flights = FXCollections.observableArrayList();
    ObservableList<Reisende> passasjerListe = FXCollections.observableArrayList();
    ObservableList<Gruppe> grupper = FXCollections.observableArrayList();
    ObservableList<Betalinger> betalinger = FXCollections.observableArrayList();

    @FXML
    private Button btNyFlight;
    @FXML
    private Button btNyReisende;
    @FXML
    private Button btNyGruppe;
    @FXML
    private Button btNyBetaling;
    @FXML
    private Button btSaveAll;
    @FXML
    private Label lblDBConnection;
    @FXML
    private Button btConnectDB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Last inn mock-data 
        this.lastInnData();

        // Legg objektene i en ArrayList som kan lagres i fil
        ArrayList dataToStore = new ArrayList();
        dataToStore.add(flights.addAll());
        dataToStore.add(passasjerListe.addAll());
        dataToStore.add(grupper.addAll());
        dataToStore.add(betalinger.addAll());

        // Skriv til fil
        writeFile(dataFile, dataToStore);
        

        // Last objektene i TableViews
        this.tblViewFlights.setItems(flights);
        this.tblViewReisende.setItems(passasjerListe);
        this.tblViewGrupper.setItems(grupper);
        this.tblViewBetalinger.setItems(betalinger);

        ObservableList<TableColumn> colf = this.tblViewFlights.getColumns();
        for (TableColumn c : colf) {
            c.setCellValueFactory(new PropertyValueFactory(c.getId()));
        }

        ObservableList<TableColumn> colr = this.tblViewReisende.getColumns();
        for (TableColumn c : colr) {
            c.setCellValueFactory(new PropertyValueFactory(c.getId()));
        }

        ObservableList<TableColumn> colg = this.tblViewGrupper.getColumns();
        for (TableColumn c : colg) {
            c.setCellValueFactory(new PropertyValueFactory(c.getId()));
        }

        ObservableList<TableColumn> colb = this.tblViewBetalinger.getColumns();
        for (TableColumn c : colb) {
            c.setCellValueFactory(new PropertyValueFactory(c.getId()));
        }

    }

    @FXML
    private void btClickNyFlight(ActionEvent event) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditFlight.fxml"));
            
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) fxmlLoader.load()));
            stage.setTitle("Edit Flight");
            stage.setUserData(this);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void lastInnData() {
        
        
        
        try {
            
            // Oblig 2, lese fra fil
            //flights.addAll(readFile(dataFile));
            
            // Oblig 3, leser fra database

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @FXML
    private void btClickNyReisende(ActionEvent event) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditReisende.fxml"));

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) fxmlLoader.load()));
            stage.setTitle("Edit Reisende");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void btClickNyGruppe(ActionEvent event) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditGruppe.fxml"));

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) fxmlLoader.load()));
            stage.setTitle("Edit Gruppe");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void btClickNyBetaling(ActionEvent event) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditBetaling.fxml"));

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) fxmlLoader.load()));
            stage.setTitle("Edit Betalinger");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList readFile(String dataFileName) {
        // Metode for å lese data fra fil til ArrayList
        ArrayList objects = new ArrayList();
        try {

            FileInputStream fis = new FileInputStream(dataFileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            objects = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Lest data fra fil OK!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class Not Found.");
            c.printStackTrace();
        }

        return objects;
    }

    public static void writeFile(String dataFileName, ArrayList arrayList) {
        //Metode for å skrive data (binært) til fil
        
        try {
            FileOutputStream fos = new FileOutputStream(dataFileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(arrayList);
            oos.close();
            fos.close();
            System.out.println("Lagret fil OK!");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void addReisendeToPassasjerListe(Reisende r) {
        // Metode som legger til Reisende-objekt i passasjerListe
        // Skal hente reisende-objekt fra EditReisendeController.java
        this.passasjerListe.add(r);
    }

    public void addFlightToFlights(Flight f) {
        // Metode som legger til Flight-objekt i flights
        // Skal hente flight-objekt fra EditFlightController.java
        this.flights.add(f);
    }

    void addGruppeToGrupper(Gruppe g) {
        // Metode som legger til Gruppe-objekt i grupper
        // Skal hente gruppe-objekt fra EditGruppeController.java
        this.grupper.add(g);
    }

    void addBetalingToBetalinger(Betalinger b) {
        // Metode som legger til Betaling-objekt i betalinger
        // Skal hente betaling-objekt fra EditBetalingController.java
        this.betalinger.add(b);
    }

    @FXML
    private void btClickSaveAll(ActionEvent event) {
        

        ArrayList dataToStore = new ArrayList();
        
        for (Flight fl : flights) {
            dataToStore.add(fl.makeWritableObject());
        }
               

        //writeFile(dataFile, dataToStore );
    }

    @FXML
    private void btClickConnectDB(ActionEvent event) throws SQLException {
        
        lblDBConnection.setText("Kobler til database Booking...");
        
        Database db = new Database();
        lblDBConnection.setText("Koblet til database " + db.getConnection().toString());
        
        for (Flight f : db.readAllFlights()) {
            this.flights.add(f);
    }
        

    }
}
