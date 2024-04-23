package com.example.tp11.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Voiture {
    @Id
    @GeneratedValue
    private Long id;




    @Column(name = "serie")
    private String serie;

    public Voiture() {

    }

    public Voiture(Long id, Integer cin, String serie, LocalDate dmm, List<Location> locations) {
        this.id = id;
        this.serie = serie;
        this.dmm = dmm;
        this.locations = locations;
    }

    @Column(name = "DMM")
    private LocalDate dmm;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations = new ArrayList<Location>();

    @ManyToOne
    @JoinColumn(name = "Modelid")
    private Modele model;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Modele getModel() {
        return model;
    }

    public void setModel(Modele model) {
        this.model = model;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public LocalDate getDmm() {
        return dmm;
    }

    public void setDmm(LocalDate dmm) {
        this.dmm = dmm;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
