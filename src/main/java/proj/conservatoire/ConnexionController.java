/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proj.conservatoire;

import Data.DAO;
import Models.Eleve;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static proj.conservatoire.App.loadFXML;

/**
 * FXML Controller class
 *
 * @author miste
 */
public class ConnexionController implements Initializable {
    
    private final String LOGIN = "tchevalier0";
    private final String PASSWORD = "test";
    
    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button validerButton;
    
    @FXML
    private Label errorMessage;
    
    private MenuController menuController;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginTextField.setText(LOGIN);
        passwordField.setText(PASSWORD);
        
        errorMessage.setText("");
    }
    
    /**
     * Permet à l'utilisateur de se connecter à l'application
     * à l'aide du bouton "Valider". 
     * @throws SQLException 
     * @throws java.io.IOException 
     */
    public void seConnecter() throws SQLException, IOException
    {
        String login = loginTextField.getText();
        String password = passwordField.getText();
        
        // Check si les champs sont vides
        if(login.isEmpty() || password.isEmpty())
        {
            errorMessage.setText("Vous n'avez pas rempli l'un des deux champs.");
        }
        
        else {
            
            // Appel de la procédure
            CallableStatement call = DAO.getConnection().prepareCall("call getLoginEleve(?);");
            call.setString(1, login);
        
            ResultSet res = call.executeQuery();
        
            // Check si le MDP saisi est égal au MDP de l'élève dans la BDD
            if(res.next() && password.equals(res.getString("MDP")))
            {
                // Création de l'objet élève
                createEleve(res);
                
                errorMessage.setText("Vous êtes connecté!"); // Juste pour vérifier...
                
                validerButton.setDisable(true);
                
                // Load the menu scene
                Parent menuRoot = FXMLLoader.load(getClass().getResource("/vues/menu.fxml"));
                Scene menuScene = new Scene(menuRoot);
                Stage stage = (Stage) validerButton.getScene().getWindow();
                stage.setScene(menuScene);
                stage.show();
                
            }
            else errorMessage.setText("Votre login ou votre mot de passe est incorrect!");
 
        }
        
    }
    
    /**
     * Crée un objet de type Eleve à partir de la base de données.
     * @param res
     * @throws SQLException 
     */
    private void createEleve(ResultSet res) throws SQLException
    {
        Integer id = res.getInt("ID");
        String nom = res.getString("NOM");
        String prenom = res.getString("PRENOM");
        Integer cycle = res.getInt("CYCLE");
        Integer anneeCycle = res.getInt("ANNEE_CYCLE");
            
        Eleve eleve = new Eleve(id, nom, prenom, cycle, anneeCycle);
        
        App.setEleve(eleve);
    }
}
