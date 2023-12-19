/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proj.conservatoire;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author miste
 */
public class ConnexionController implements Initializable {
    
    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button validerButton;
    
    @FXML
    private Label errorMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMessage.setText("");
    }
    
    /**
     * Méthode test pour gérer les messages d'erreur.
     * (Susceptible de ne pas être gardée.)
     */
    public void handleError()
    {
        if(loginTextField.getText().isEmpty() || passwordField.getText().isEmpty())
        {
            errorMessage.setText("Erreur ! Vous n'avez pas rempli l'un des deux champs.");
        }
        else errorMessage.setText("");
    }
    
}
