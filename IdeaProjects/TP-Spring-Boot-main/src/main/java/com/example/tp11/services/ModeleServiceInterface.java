package com.example.tp11.services;

import com.example.tp11.Entity.Modele;

import java.util.List;
import java.util.Optional;

public interface ModeleServiceInterface {
    Modele getModeleByNom(String nom);
    List<Modele> getAllModele();

    Modele CreateModele(Modele modele);
    Optional<Modele> getModeleById(long id );
    Modele updateModele(Modele modele);
    Void deleteModele(Long id);
}
