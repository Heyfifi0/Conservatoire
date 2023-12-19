/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author miste
 */
public class Partition {
    private Integer id;
    private String nomPartition;
    private String nomAuteur;
    
    /**
     * Constructeur de la classe Partition.
     * @param id
     * @param nomPartition
     * @param nomAuteur 
     */
    public Partition(Integer id, String nomPartition, String nomAuteur)
    {
        this.id = id;
        this.nomPartition = nomPartition;
        this.nomAuteur = nomAuteur;
    }
    
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
