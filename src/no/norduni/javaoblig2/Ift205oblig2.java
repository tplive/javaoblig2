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
    
    static Stage stagenVaar;
    static Scene sceneReisende;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        stagenVaar = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Parent reisende = FXMLLoader.load(getClass().getResource("FXMLReisende.fxml"));
        
        
        Scene scene = new Scene(root);
        Scene reisendeScene = new Scene(reisende);
        
        reisendeScene = sceneReisende;
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
