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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author miste
 */
public class ChercherPartitionController implements Initializable {
    
    @FXML
    private TableView<Partition> listePartitions;
    
    private final ObservableList<Partition> lesPartitions = FXCollections.observableArrayList();
    
    @FXML
    private TableColumn<Partition, String> colonneNom;
    
    @FXML
    private TableColumn<Partition, String> colonneAuteur;

    @FXML
    private TableColumn<Partition, Number> colonnePage;
    
    @FXML
    private TextField barreRecherche;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listePartitions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        colonneNom.setCellValueFactory(cellData -> cellData.getValue().getNomPartitionProperty());
        colonneAuteur.setCellValueFactory(cellData -> cellData.getValue().getNomAuteurProperty());
        colonnePage.setCellValueFactory(cellData -> cellData.getValue().getNumeroPageProperty());


        try {
            remplirListe();
        } catch (SQLException ex) {
            Logger.getLogger(ChercherPartitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    /**
     * Remplit la liste des partitions de l'élève à partir de la BDD.
     * @throws SQLException 
     */
    private void remplirListe() throws SQLException
    {
        CallableStatement call = DAO.getConnection().prepareCall("call getPartitionEleve(?);");
        call.setInt(1, App.getEleve().getId());
        
        ResultSet res = call.executeQuery();
        
        while(res.next())
        {
            Integer id = res.getInt("ID");
            String nom = res.getString("NOM");
            String auteur = res.getString("AUTEUR");
            Integer numeroPage = res.getInt("NUM_PAGE_CLASSEUR");
            
            Partition partition = new Partition(id, nom, auteur, numeroPage);
            
            lesPartitions.add(partition);
        }
        listePartitions.setItems(lesPartitions);
    }
    
    /**
     * Permet de rechercher une partition par auteur,
     * avec la barre de recherche.
     */
    public void rechercherAuteur()
    {
        ObservableList<Partition> filteredPartitions = FXCollections.observableArrayList();
        
        for(Partition partition : listePartitions.getItems())
        {
            if(partition.getNomAuteur().contains(barreRecherche.getText()) && barreRecherche.getText().length() > 0)
            {
                filteredPartitions.add(partition);
            }
        }
        
        if(barreRecherche.getText().equals(""))
        {
            listePartitions.setItems(lesPartitions);
        }
        else{
            listePartitions.setItems(filteredPartitions);
        }
    }
}
