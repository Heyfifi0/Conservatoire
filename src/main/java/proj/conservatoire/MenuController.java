/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proj.conservatoire;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author miste
 */
public class MenuController implements Initializable {
    
    @FXML
    private Button lienHoraires;
    
    @FXML
    private Button lienAjouterPartition;

    @FXML
    private Button lienChercherPartition;
    
    @FXML
    private Button lienDeconnexion;

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
     * Permet d'afficher la vue précisée en UserData à côté du menu (voir menu.fxml).
     * @param event Un évènement.
     */
    @FXML
    public void afficherVue(ActionEvent event)
    {
        String vue = (String) ((Node)event.getSource()).getUserData();
        
        loadFXML(getClass().getResource(vue));
        
        System.out.println(String.format("\nSwitch sur la vue : %s", vue));
        
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        lienChercherPartition.setDisable(true);
//        lienAjouterPartition.setDisable(true);
//        lienDeconnexion.setDisable(true);

    }
    
    /**
     * Permet à l'utilisateur de se déconnecter
     * à l'aide du bouton "Se déconnecter".
     * @param event Un évènement.
     */
    @FXML
    public void seDeconnecter(ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Voulez-vous vraiment vous déconnecter ?", ButtonType.APPLY, ButtonType.CANCEL);
        alert.showAndWait();
        
        if(alert.getResult() == ButtonType.APPLY)
        {
           try {
                App.setEleve(null);
                
                Parent loginRoot = FXMLLoader.load(getClass().getResource("/vues/connexion_v2.fxml"));
                Scene loginScene = new Scene(loginRoot);
                Stage stage = (Stage) lienDeconnexion.getScene().getWindow();
                stage.setScene(loginScene);
                stage.show();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    
    /**
     * Active les boutons sur le menu au moment de la connexion (inutilisée).
     * @throws java.sql.SQLException
     */
    public void activerBoutons() throws SQLException
    {
        lienChercherPartition.setDisable(false);
        lienAjouterPartition.setDisable(false);
        lienDeconnexion.setDisable(false);
        

    }
    
}
