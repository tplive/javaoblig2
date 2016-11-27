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
public class EditBetalingController implements Initializable {

    @FXML
    private Button btCancel;
    @FXML
    private Button btSaveBetaling;
    @FXML
    private TextField tfPassNo;
    @FXML
    private TextField tfBetalingsMaate;
    @FXML
    private TextField tfSum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btCancelClick(ActionEvent event) {
        Stage stage = (Stage) btCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btSaveBetalingClick(ActionEvent event) {
        Betalinger betaling = new Betalinger();
        betaling.setBetalingsMaate(Integer.parseInt(tfBetalingsMaate.getText()));
        betaling.setPersonPassNo(tfPassNo.getText());
        betaling.setSum(Double.parseDouble(tfSum.getText()));

        // Legg til betaling i betalinger i main controller
        FXMLMainDocumentController mainController = new FXMLMainDocumentController();
        mainController.addBetalingToBetalinger(betaling);

    }

}
