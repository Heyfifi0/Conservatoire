/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 * La classe Partition.
 * @author miste
 */
public class Partition {
    private Integer id;
    private String nomPartition;
    private String nomAuteur;
    
    /**
     * Constructeur de la classe Partition.
     * @param id L'identifiant de la partition.
     * @param nomPartition Le nom de la partition.
     * @param nomAuteur Le nom de l'auteur de la partition.
     */
    public Partition(Integer id, String nomPartition, String nomAuteur)
    {
        this.id = id;
        this.nomPartition = nomPartition;
        this.nomAuteur = nomAuteur;
    }
    
    
    // Getters
    public Integer getId()
    {
        return this.id;
    }
    
    public String getNomPartition()
    {
        return this.nomPartition;
    }
    
    public String getNomAuteur()
    {
        return this.nomAuteur;
    }
}
