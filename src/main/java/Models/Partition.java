/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * La classe Partition.
 * @author miste
 */
public class Partition {
    private IntegerProperty id;
    private StringProperty nomPartition;
    private StringProperty nomAuteur;
    
    /**
     * Constructeur de la classe Partition.
     * @param id L'identifiant de la partition.
     * @param nomPartition Le nom de la partition.
     * @param nomAuteur Le nom de l'auteur de la partition.
     */
    public Partition(Integer id, String nomPartition, String nomAuteur)
    {
        this.id = new SimpleIntegerProperty(id);
        this.nomPartition = new SimpleStringProperty(nomPartition);
        this.nomAuteur = new SimpleStringProperty(nomAuteur);
    }
    
    
    // Getters
    public Integer getId()
    {
        return this.id.get();
    }
    
    public String getNomPartition()
    {
        return this.nomPartition.get();
    }
    
    public String getNomAuteur()
    {
        return this.nomAuteur.get();
    }
    
    // Getters (Property)
    public IntegerProperty getIdProperty()
    {
        return this.id;
    }
    
    public StringProperty getNomPartitionProperty()
    {
        return this.nomPartition;
    }
    
    public StringProperty getNomAuteurProperty()
    {
        return this.nomAuteur;
    }
}
