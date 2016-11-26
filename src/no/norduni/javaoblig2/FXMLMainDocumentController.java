/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thomas
 * 
 * Change to a different FXML document: http://www.javafxtutorials.com/tutorials/switching-to-different-screens-in-javafx-and-fxml/
 * 
 */
public class FXMLMainDocumentController implements Initializable {
    
    @FXML
    private TableView tblViewFlights;
    @FXML
    private TableView tblViewReisende;
    @FXML
    private TableView tblViewGrupper;
    @FXML
    private TableView tblViewBetalinger;
    
    ObservableList<Flight> flights = FXCollections.observableArrayList();
    ObservableList<Reisende> passasjerListe = FXCollections.observableArrayList();
    ObservableList<Gruppe> grupper = FXCollections.observableArrayList();
    ObservableList<Betalinger> betalinger = FXCollections.observableArrayList();
    
    @FXML
    private Button btNyFlight;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Flight flight = new Flight();
        flight.setFlightNo("WF1233");
        flight.setTilFlyplass("BNN");
        flight.setFraFlyplass("MQN");
        flight.setStartTid("2016/12/20");
        flight.setReiseTid(55);
        flight.setAntallSeter(23);
        
        flights.add(flight);
        
        Reisende reisende = new Reisende();
        reisende.setNavn("Eline Westerberg");
        reisende.setKjonn("K");
        reisende.setAlder(28);
        reisende.setPassNo("123123456");
        reisende.setGruppeKode(1);
        
        passasjerListe.add(reisende);
        
        Gruppe gruppe = new Gruppe();
        gruppe.setFlightNo("WF1233");
        gruppe.setGruppeKode(1);
        
        grupper.add(gruppe);
        
        Betalinger betaling = new Betalinger();
        betaling.setPersonPassNo(123123456);
        betaling.setBetalingsMaate(0);
        betaling.setSum(2500.50);
        
        betalinger.add(betaling);
        
        this.tblViewFlights.setItems(flights); 
        this.tblViewReisende.setItems(passasjerListe);
        this.tblViewGrupper.setItems(grupper);
        this.tblViewBetalinger.setItems(betalinger);
        
        ObservableList<TableColumn> colf = this.tblViewFlights.getColumns();
        for(TableColumn c : colf) {
            c.setCellValueFactory(new PropertyValueFactory(c.getId()));
            }
        
        ObservableList<TableColumn> colr = this.tblViewReisende.getColumns();
        for(TableColumn c : colr) {
            c.setCellValueFactory(new PropertyValueFactory(c.getId()));
            }
        
        ObservableList<TableColumn> colg = this.tblViewGrupper.getColumns();
        for(TableColumn c : colg) {
            c.setCellValueFactory(new PropertyValueFactory(c.getId()));
            }
        
        ObservableList<TableColumn> colb = this.tblViewBetalinger.getColumns();
        for(TableColumn c : colb) {
            c.setCellValueFactory(new PropertyValueFactory(c.getId()));
            }
        
        
    }    

    @FXML
    private void btClickNyFlight(ActionEvent event) throws IOException {
        
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditFlight.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stageEdit = new Stage();
                stageEdit.setScene(new Scene(root1));  
                stageEdit.show();
        } catch(IOException e) {
           e.printStackTrace();
          }

 
    }

    
}
