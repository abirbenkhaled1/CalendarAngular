package com.example.tp11.services;

import com.example.tp11.Entity.Client;
import com.example.tp11.Entity.Voiture;

import java.util.List;

public interface VoitureServiceInterface {
    List<Voiture> getAllVoiture();

    Voiture CreateVoiture(Voiture voiture);
    Voiture getVoitureById(long id );
    Voiture updateVoiture(Voiture voiture);
    Void deleteVoiture(Long id);
}
