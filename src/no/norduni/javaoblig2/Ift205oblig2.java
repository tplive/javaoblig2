/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Thomas
 */
public class Ift205oblig2 extends Application {
    
    static Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainDocument.fxml"));
        
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
