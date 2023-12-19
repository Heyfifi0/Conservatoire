/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.time.LocalDate;

/**
 *
 * @author miste
 */
public class Eleve {
    private Integer id;
    private String nom;
    private String prenom;
    private Integer cycle;
    private Integer anneeCycle;
    private String login;
    private String password;
    
    /**
     * Constructeur de la classe Eleve.
     * @param id
     * @param nom
     * @param prenom
     * @param cycle
     * @param anneeCycle
     * @param login
     * @param password
     */
    public Eleve(Integer id, String nom, String prenom, Integer cycle, Integer anneeCycle, String login, String password)
    {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.cycle = cycle;
        this.anneeCycle = anneeCycle;
    }
    
    
    // Getters
    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
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
