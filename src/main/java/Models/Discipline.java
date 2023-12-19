/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 * La classe Discipline.
 * @author miste
 */
public class Discipline {
    private Integer id;
    private String libelle;
    
    /**
     * Constructeur de la classe Discipline.
     * @param id L'identifiant de la discipline.
     * @param libelle Le libellé de la discipline.
     */
    public Discipline(Integer id, String libelle)
    {
        this.id = id;
        this.libelle = libelle;
    }
    
    
    // Getters
    public Integer getId()
    {
        return this.id;
    }
    
    public String getLibelle()
    {
        return this.libelle;
    }
}
