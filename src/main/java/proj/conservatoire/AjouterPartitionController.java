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
import javafx.scene.control.ButtonType;
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
    
    private ObservableList<Partition> lesPartitions = FXCollections.observableArrayList();
    
    @FXML
    private TextField nomPartition;
    
    @FXML
    private TextField nomAuteur;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colonneNom.setCellValueFactory(cellData -> cellData.getValue().getNomPartitionProperty());
        colonneAuteur.setCellValueFactory(cellData -> cellData.getValue().getNomAuteurProperty());
        
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
     * Ajoute une partition à la liste.
     */
    public void ajouterPartition()
    {
        String nom = nomPartition.getText();
        String auteur = nomAuteur.getText();
        
        if(nom.isEmpty() || auteur.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vous n'avez pas rempli l'un des deux champs.", ButtonType.CLOSE);
        }
        
        
    }
    
    
    /**
     * Vérifie si une partition existe.
     */
    private void partitionExiste()
    {
        // TODO
    }
    
    /**
     * Ajoute la partition sélectionnée au classeur de l'élève.
     */
    private void ajouterPartitionClasseur()
    {
        // TODO
    }
    

}
