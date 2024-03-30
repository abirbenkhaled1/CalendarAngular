package com.example.tp11.Repo;

import com.example.tp11.Entity.Modele;
import com.example.tp11.Entity.Voiture;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoitureRepoCustom {

//    List<Voiture> findVoitureByModel(Model model);

    @Query("Select v from Voiture v where v.model = ?1")
    List<Voiture> ListeVoitureByModel(Modele model);

}