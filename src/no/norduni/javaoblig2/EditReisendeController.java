/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class EditReisendeController implements Initializable {

    @FXML
    private TextField tfNavn;
    @FXML
    private TextField tfKjonn;
    @FXML
    private TextField tfAlder;
    @FXML
    private TextField tfPassNo;
    @FXML
    private TextField tfGruppeKode;
    @FXML
    private Button btSaveReisende;
    @FXML
    private Button btCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btSaveReisendeClick(ActionEvent event) {
        
        // Hent data fra textfields i et nytt Reisende-objekt
        Reisende reisende = new Reisende();
        reisende.setNavn(tfNavn.getText());
        reisende.setAlder(Integer.parseInt(tfAlder.getText()));
        reisende.setKjonn(tfKjonn.getText());
        reisende.setPassNo(tfPassNo.getText());
        reisende.setGruppeKode(Integer.parseInt(tfGruppeKode.getText()));
        
        FXMLMainDocumentController mainController = new FXMLMainDocumentController();
        mainController.addReisendeToPassasjerListe(reisende);
        
        // Lukk dialogen etter lagring
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
        
    }

    @FXML
    private void btCancelClick(ActionEvent event) {
        Stage stage = (Stage) btCancel.getScene().getWindow();
        stage.close();
    }
    
}
