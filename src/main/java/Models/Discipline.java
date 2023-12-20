/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;

/**
 * La classe Discipline.
 * @author miste
 */
public class Discipline {
    private Integer id;
    private String libelle;
    private ArrayList<Eleve> lesEleves;
    
    /**
     * Constructeur de la classe Discipline.
     * @param id L'identifiant de la discipline.
     * @param libelle Le libellé de la discipline.
     */
    public Discipline(Integer id, String libelle)
    {
        this.id = id;
        this.libelle = libelle;
        
        lesEleves = new ArrayList<>();
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
