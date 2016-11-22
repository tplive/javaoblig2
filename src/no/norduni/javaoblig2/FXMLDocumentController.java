/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 * 
 * @author Thomas
 */
public class FXMLDocumentController implements Initializable {
    
    private Flight flight;
    private ObservableList<Flight> flighter;
    @FXML
    private TableView flightTableView;
    @FXML
    private Button btnLoadData;
    @FXML
    private TableColumn<?, ?> flightNo;
    @FXML
    private TableColumn<?, ?> fraFlyplass;
    @FXML
    private TableColumn<?, ?> tilFlyplass;
    @FXML
    private TableColumn<?, ?> startTid;
    @FXML
    private TableColumn<?, ?> reiseTid;
    @FXML
    private TableColumn<?, ?> antallSeter;
    @FXML
    private Button btnReisende;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        
        Flight flight = new Flight();
        flight.setFlightNo("WF1233");
        flight.setTilFlyplass("BNN");
        flight.setFraFlyplass("MQN");
        flight.setStartTid("2016/12/20");
        flight.setReiseTid(55);
        flight.setAntallSeter(23);
        
        flights.add(flight);
        //bookingDataStore.writeFile("Flights.dat", (ArrayList) flights);
        
        this.flightTableView.setItems(flights); 
        
        ObservableList<TableColumn> col = this.flightTableView.getColumns();
        for(TableColumn c : col) {
            c.setCellValueFactory(new PropertyValueFactory(c.getId()));
        }
        }

    @FXML
    private void loadDataHandler(ActionEvent event) {
        
        // Virker ikke
        //bookingDataStore.readFile("Flight.dat");
    }

    @FXML
    private void loadReisendeView(ActionEvent event) {
        Ift205oblig2.stagenVaar.setScene(Ift205oblig2.sceneReisende);
        Ift205oblig2.stagenVaar.show();
        

    }
}    


    

