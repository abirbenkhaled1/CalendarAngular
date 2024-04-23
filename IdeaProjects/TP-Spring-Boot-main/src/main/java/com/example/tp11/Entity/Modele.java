package com.example.tp11.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Modele {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nom")
    private String nom;

    public Modele() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Modele(Long id, String nom, List<Voiture> voitures) {
        this.id = id;
        this.nom = nom;
        this.voitures = voitures;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "model")
    private List<Voiture> voitures = new ArrayList<Voiture>();


}
