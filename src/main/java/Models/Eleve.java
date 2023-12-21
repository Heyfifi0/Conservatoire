/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;

/**
 * La classe Eleve.
 * @author miste
 */
public class Eleve {
    private Integer id;
    private String nom;
    private String prenom;
    private Integer cycle;
    private Integer anneeCycle;
    
    private Discipline discipline; //Jsp quoi en faire...
    
    /**
     * Constructeur de la classe Eleve.
     * @param id L'identifiant de l'élève.
     * @param nom Le nom de famille de l'élève.
     * @param prenom Le prénom de l'élève.
     * @param cycle Le cycle de l'élève.
     * @param anneeCycle L'année du cycle de l'élève.
     */
    public Eleve(Integer id, String nom, String prenom, Integer cycle, Integer anneeCycle)
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cycle = cycle;
        this.anneeCycle = anneeCycle;
    }
    
    
    // Getters
    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Integer getCycle() {
        return cycle;
    }

    public Integer getAnneeCycle() {
        return anneeCycle;
    }
    
    
    
    
}
