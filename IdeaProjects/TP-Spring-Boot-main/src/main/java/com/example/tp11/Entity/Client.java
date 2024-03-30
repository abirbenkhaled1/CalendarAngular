package com.example.tp11.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "cin")
    private Integer cin;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;
    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "client")
    private List<Location> locations = new ArrayList<Location>();

    public Client(Long id, Integer cin, String nom, String prenom, String adresse) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Client(Long id, Integer cin, String nom, String prenom, String adresse, List<Location> locations) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.locations = locations;
    }

    public Client() {

    }


    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
