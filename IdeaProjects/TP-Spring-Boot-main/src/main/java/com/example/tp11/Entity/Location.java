package com.example.tp11.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Date_D")
    private LocalDate Date_d ;

    @Column(name = "Date_f")
    private LocalDate Date_f ;

    @Column(name = "prix")
    private Integer prix;
    @ManyToOne
    @JoinColumn(name = "Voitureid")

    private Voiture voiture;

    @ManyToOne
    @JoinColumn(name = "Clientid")

    private Client client;

    public Location() {

    }


    public LocalDate getDate_d() {
        return Date_d;
    }

    public Location(Long id, LocalDate date_d, LocalDate date_f, Integer prix, Integer prixj) {
        this.id = id;
        Date_d = date_d;
        Date_f = date_f;
        this.prix = prix;
        this.prixj = prixj;
    }

    public void setDate_d(LocalDate date_d) {
        Date_d = date_d;
    }

    public LocalDate getDate_f() {
        return Date_f;
    }

    public void setDate_f(LocalDate date_f) {
        Date_f = date_f;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getPrixj() {
        return prixj;
    }

    public void setPrixj(Integer prixj) {
        this.prixj = prixj;
    }

    @Column(name = "prixj")
    private Integer prixj;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
