/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proj.conservatoire;

import Data.DAO;
import Models.Partition;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author miste
 */
public class AjouterPartitionController implements Initializable {
    
    @FXML
    private TableView<Partition> listePartitions;
    
    @FXML
    private TableColumn<Partition, String> colonneNom;
    
    @FXML
    private TableColumn<Partition, String> colonneAuteur;
    
    private final ObservableList<Partition> lesPartitions = FXCollections.observableArrayList();
    
    @FXML
    private Label labelNom;
    
    @FXML
    private Label labelAuteur;
    
    @FXML
    private TextField nomPartition;
    
    @FXML
    private TextField nomAuteur;
    
    @FXML
    private Button confirmerAjout;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelNom.setVisible(false);
        nomPartition.setVisible(false);
        
        labelAuteur.setVisible(false);
        nomAuteur.setVisible(false);
        
        confirmerAjout.setVisible(false);
        
        colonneNom.setCellValueFactory(cellData -> cellData.getValue().getNomPartitionProperty());
        colonneAuteur.setCellValueFactory(cellData -> cellData.getValue().getNomAuteurProperty());
        
        //listePartitions.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        try {
            remplirListe();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterPartitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Remplit la liste des partitions à partir de la BDD.
     * @throws SQLException 
     */
    private void remplirListe() throws SQLException
    {
        CallableStatement call = DAO.getConnection().prepareCall("call getPartitions();");
        ResultSet res = call.executeQuery();
        
        while(res.next())
        {
            
            String nom = res.getString("NOM");
            String auteur = res.getString("AUTEUR");
            
            Partition partition = new Partition(nom, auteur);
            lesPartitions.add(partition);
        }
        listePartitions.setItems(lesPartitions);
    }
    
    /**
     * Active le formulaire pour ajouter une partition avec le bouton "Ajouter une partition".
     */
    public void showAjouterPartition()
    {
        labelNom.setVisible(true);
        nomPartition.setVisible(true);
        
        labelAuteur.setVisible(true);
        nomAuteur.setVisible(true);
        
        confirmerAjout.setVisible(true);
    }
    
    /**
     * Ajoute une partition à la liste.
     */
    public void ajouterPartition() throws SQLException
    {
        String nom = nomPartition.getText();
        String auteur = nomAuteur.getText();
        
        // Check si les champs sont vides
        if(nom.isEmpty() || auteur.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vous n'avez pas rempli l'un des deux champs.", ButtonType.CLOSE);
            alert.showAndWait();
        }
        
        else {
            CallableStatement call = DAO.getConnection().prepareCall("call insertPartition(?, ?);");
            call.setString(1, nom);
            call.setString(2, auteur);

            Alert alert = new Alert(Alert.AlertType.WARNING, "Voulez-vous vraiment ajouter cette partition ?", ButtonType.APPLY, ButtonType.CANCEL);
            alert.showAndWait();
            
            if (alert.getResult() == ButtonType.APPLY)
            {
                call.execute();
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Votre partition a été ajoutée à la liste!", ButtonType.CLOSE);
                confirm.showAndWait();
                
                nomPartition.clear();
                nomAuteur.clear();
                
                //listePartitions.refresh(); // Marche pas lol
            }
            else {
                nomPartition.clear();
                nomAuteur.clear();
            }

        }

    }
    
    /**
     * Ajoute la partition sélectionnée au classeur de l'élève.
     */
    public void ajouterPartitionClasseur() throws SQLException
    {
        // Récupérer l'item choisi ...
        Partition partitionChoisie = listePartitions.getSelectionModel().getSelectedItem();
        
        CallableStatement call = DAO.getConnection().prepareCall("call insertPartitionEleve(?, ?, ?)");
        // TODO ...
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez-vous ajouter cette partition au classeur ?", ButtonType.APPLY, ButtonType.CANCEL);
        alert.showAndWait();
        
        if(alert.getResult() == ButtonType.APPLY)
        {
            // Exécuter la requête ...
            
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "La partition a été ajoutée au classeur.", ButtonType.CLOSE);
        }
        else {
            // TODO ...
        }
    }
    

}
