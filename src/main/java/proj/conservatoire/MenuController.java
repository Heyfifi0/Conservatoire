/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proj.conservatoire;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author miste
 */
public class MenuController implements Initializable {
    
    @FXML
    private Button lienAjouterPartition;

    @FXML
    private Button lienChercherPartition;
    
    @FXML
    private BorderPane contentPane;
    
    /**
     * Charge une vue FXML et l'attribue au centre du BorderPane.
     * @param url 
     */
    private void loadFXML(URL url)
    {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            contentPane.setCenter(loader.load());
        } catch (IOException e) {
        }
    }
    
    /**
     * Permet d'afficher la vue précisée en UserData à côté du menu.
     * @param event Un évènement.
     */
    @FXML
    public void afficherVue(ActionEvent event)
    {
        String vue = (String) ((Node)event.getSource()).getUserData();
        
        loadFXML(getClass().getResource(vue));
        
        System.out.println("Switch sur la vue : " + vue);
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lienChercherPartition.setDisable(true);
        lienAjouterPartition.setDisable(true);
    }    
    
}