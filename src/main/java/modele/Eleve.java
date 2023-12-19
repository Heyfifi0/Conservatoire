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
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private Integer cycle;
    private LocalDate anneeCycle;
    
    /**
     * Constructeur de la classe Eleve.
     * @param id
     * @param login
     * @param password
     * @param nom
     * @param prenom
     * @param cycle
     * @param anneeCycle 
     */
    public Eleve(Integer id, String login, String password, String nom, String prenom, Integer cycle, LocalDate anneeCycle)
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

    public LocalDate getAnneeCycle() {
        return anneeCycle;
    }
    
    
    
    
}
