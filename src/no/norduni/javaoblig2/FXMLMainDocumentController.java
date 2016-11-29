/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
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

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void lastInnData() {
        try {

            flights.addAll(readFile(dataFile));

            Flight flight = new Flight();
            flight.setFlightNo("WF1233");
            flight.setTilFlyplass("BNN");
            flight.setFraFlyplass("MQN");
            flight.setStartTid("2016/12/20");
            flight.setReiseTid(55);
            flight.setAntallSeter(23);

            Reisende reisende1 = new Reisende();
            reisende1.setNavn("Eline Westerberg");
            reisende1.setKjonn("K");
            reisende1.setAlder(28);
            reisende1.setPassNo("123123456");
            reisende1.setGruppeKode(1);

            Reisende reisende2 = new Reisende();
            reisende2.setNavn("Thomas Qvidahl");
            reisende2.setKjonn("M");
            reisende2.setAlder(41);
            reisende2.setPassNo("NO123123567");
            reisende2.setGruppeKode(1);

            Gruppe gruppe = new Gruppe();
            gruppe.setFlightNo("WF1233");
            gruppe.setGruppeKode(1);

            Betalinger betaling1 = new Betalinger();
            betaling1.setPersonPassNo("123123456");
            betaling1.setBetalingsMaate(0);
            betaling1.setSum(2500.50);

            Betalinger betaling2 = new Betalinger();
            betaling2.setPersonPassNo("NO123123567");
            betaling2.setBetalingsMaate(0);
            betaling2.setSum(2750.70);

            this.flights.add(flight);
            this.passasjerListe.add(reisende1);
            this.passasjerListe.add(reisende2);
            this.grupper.add(gruppe);
            this.betalinger.add(betaling1);
            this.betalinger.add(betaling2);

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
        ArrayList<Flight> objects = new ArrayList<>();
        try {

            FileInputStream fis = new FileInputStream(dataFileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            objects = (ArrayList) ois.readObject();
            ois.close();
            fis.close();

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
}
