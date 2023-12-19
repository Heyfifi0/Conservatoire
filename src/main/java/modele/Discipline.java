/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author miste
 */
public class Discipline {
    private Integer id;
    private String libelle;
    
    /**
     * Constructeur de la classe Discipline.
     * @param id
     * @param libelle 
     */
    public Discipline(Integer id, String libelle)
    {
        this.id = id;
        this.libelle = libelle;
    }
    
    public Integer getId()
    {
        return this.id;
    }
    
    public String getLibelle()
    {
        return this.libelle;
    }
}
