/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class FXMLReisendeController implements Initializable {

    @FXML
    private TableColumn<?, ?> navn;
    @FXML
    private TableColumn<?, ?> kjonn;
    @FXML
    private TableColumn<?, ?> alder;
    @FXML
    private TableColumn<?, ?> passNo;
    @FXML
    private TableColumn<?, ?> gruppeKode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
