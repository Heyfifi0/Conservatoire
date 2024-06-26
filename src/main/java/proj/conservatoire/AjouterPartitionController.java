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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

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
    
    @FXML
    private Button ajouterClasseur;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listePartitions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        labelNom.setVisible(false);
        nomPartition.setVisible(false);
        
        labelAuteur.setVisible(false);
        nomAuteur.setVisible(false);
        
        confirmerAjout.setVisible(false);
        
        colonneNom.setCellValueFactory(cellData -> cellData.getValue().getNomPartitionProperty());
        colonneAuteur.setCellValueFactory(cellData -> cellData.getValue().getNomAuteurProperty());
        
        try {
            remplirListe();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterPartitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Remplit la liste des partitions à partir de la base de données.
     * @throws SQLException 
     */
    private void remplirListe() throws SQLException
    {
        // Appel de la procédure
        CallableStatement call = DAO.getConnection().prepareCall("call getPartitions();");
        ResultSet res = call.executeQuery();
        
        while(res.next())
        {
            Integer id = res.getInt("ID");
            String nom = res.getString("NOM");
            String auteur = res.getString("AUTEUR");
            
            Partition partition = new Partition(id, nom, auteur);
            lesPartitions.add(partition);
        }
        
        // Ajout de la liste à la table
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
     * @throws java.sql.SQLException
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

            Alert alert = new Alert(Alert.AlertType.WARNING, "Voulez-vous vraiment ajouter cette partition ?", ButtonType.APPLY, ButtonType.CANCEL);
            alert.showAndWait();
            
            if (alert.getResult() == ButtonType.APPLY)
            {
                // Appel de la procédure
                CallableStatement call = DAO.getConnection().prepareCall("call insertPartition(?, ?);");
                call.setString(1, nom);
                call.setString(2, auteur);
                
                call.execute();
                
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Votre partition a été ajoutée à la liste!", ButtonType.CLOSE);
                confirm.showAndWait();
                
                nomPartition.clear();
                nomAuteur.clear();
                
                // Rafraîchissement de la table
                listePartitions.getItems().clear();
                remplirListe();
            }
            else {
                nomPartition.clear();
                nomAuteur.clear();
            }

        }

    }
    
    /**
     * Ajoute la partition sélectionnée au classeur de l'élève.
     * @throws java.sql.SQLException
     */
    public void ajouterPartitionClasseur() throws SQLException
    {
        Integer idEleve = App.getEleve().getId();
        
        ObservableList<Partition> partitionsChoisies = listePartitions.getSelectionModel().getSelectedItems();
        
        // Check si l'élève appuie sur le bouton sans avoir sélectionné une partition
        if(partitionsChoisies.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez sélectionner une ou plusieurs partitions.", ButtonType.CLOSE);
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez-vous ajouter cette partition au classeur ?", ButtonType.APPLY, ButtonType.CANCEL);
            alert.showAndWait();

            if(alert.getResult() == ButtonType.APPLY)
            {
                 for(Partition partition : partitionsChoisies)
                 {
                     System.out.println(partition.getId() + " - " + partition.getNomPartition());
                     
                     String headerText = "Choisissez une page pour la partition : " + partition.getNomPartition() + " - " + partition.getNomAuteur();
                     
                     // Fenêtre pour demander à l'utilisateur quelle page du classeur choisir
                     TextInputDialog dialog = new TextInputDialog();
                     dialog.setHeaderText(headerText);
                     dialog.showAndWait();
                     
                     String numeroPage = dialog.getEditor().getText();
                     
                     // Appel de la procédure
                     CallableStatement call = DAO.getConnection().prepareCall("call insertPartitionEleve(?, ?, ?);");
                     call.setInt(1, idEleve);
                     call.setInt(2, partition.getId());
                     call.setInt(3, Integer.parseInt(numeroPage));
                     
                     call.execute();
                 }

                 Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "La partition a été ajoutée au classeur.", ButtonType.CLOSE);
                 confirm.showAndWait();
            }
        }
        
    }
    

}
