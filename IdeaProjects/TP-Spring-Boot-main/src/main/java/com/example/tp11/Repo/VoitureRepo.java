package com.example.tp11.Repo;

import com.example.tp11.Entity.Modele;
import com.example.tp11.Entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoitureRepo extends JpaRepository<Voiture,Long>, VoitureRepoCustom {

    List<Voiture> findByModel(Modele model);

}
