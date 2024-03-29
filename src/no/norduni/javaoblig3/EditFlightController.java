/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig3;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class EditFlightController implements Initializable {

    @FXML
    private TextField tfFlightNo;
    @FXML
    private TextField tfFraFlyplass;
    @FXML
    private TextField tfTilFlyplass;
    @FXML
    private TextField tfStartTid;
    @FXML
    private TextField tfReiseTid;
    @FXML
    private TextField tfAntallSeter;
    @FXML
    private Button btSaveFlight;
    @FXML
    private Button btCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void btSaveFlightClick(ActionEvent event) throws SQLException {
        
        // Hent inn data fra textfields inn i et Flight-objekt
        Flight flight = new Flight();
        flight.setFlightNo(tfFlightNo.getText());
        flight.setTilFlyplass(tfFraFlyplass.getText());
        flight.setFraFlyplass(tfTilFlyplass.getText());
        flight.setStartTid(tfStartTid.getText());
        flight.setReiseTid(Integer.parseInt(tfReiseTid.getText()));
        flight.setAntallSeter(Integer.parseInt(tfAntallSeter.getText()));
        
        // Legg til flight i flights i main controller
        
        Button me = (Button) event.getSource();
        FXMLMainDocumentController mainController = (FXMLMainDocumentController) ((Window) me.getScene().getWindow()).getUserData();
        mainController.addFlightToFlights(flight);
        
        Database database = new Database();
        
        database.insertFlight(flight);
        
        
        
        // Lukk dialogen etter lagring
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close(); 
  }    

    @FXML
    private void btCancelClick(ActionEvent event) {
        // Få en ref til stage hvor knappen befinner seg:
        Stage stage = (Stage) btCancel.getScene().getWindow();
        // Lukk gjeldende stage
        stage.close();
    }
    
}
