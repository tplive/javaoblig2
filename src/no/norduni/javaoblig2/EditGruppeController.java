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
 * @author Eline
 */
public class EditGruppeController implements Initializable {

    @FXML
    private Button btSaveGruppe;
    @FXML
    private Button btCancel;
    @FXML
    private TextField tfGruppeKode;
    @FXML
    private TextField tfFlightNo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btSaveGruppeClick(ActionEvent event) {
        Gruppe gruppe = new Gruppe();
        gruppe.setGruppeKode(Integer.parseInt(tfGruppeKode.getText()));
        gruppe.setFlightNo(tfFlightNo.getText());
    }
    

    @FXML
    private void btCancelClick(ActionEvent event) {
        Stage stage = (Stage) btCancel.getScene().getWindow();
        stage.close();
    }
    
}
