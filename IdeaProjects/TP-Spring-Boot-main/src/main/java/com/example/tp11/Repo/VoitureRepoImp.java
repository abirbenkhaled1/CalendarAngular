package com.example.tp11.Repo;

import com.example.tp11.Entity.Modele;
import com.example.tp11.Entity.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class VoitureRepoImp implements VoitureRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

//    @Transactional
//    public List<Voiture> findVoitureByModel(Model model) {
//        Query query=
//                entityManager.createNativeQuery("Select v.* from Voiture v where v.model.id = ?", Voiture.class);
    @Override
    public List<Voiture> ListeVoitureByModel(Modele model) {
        Query query =entityManager.createNativeQuery("Select v.* from Voiture v where v.model.id = ?", Voiture.class);
        query.setParameter(1, model.getId());

        List<Voiture> listeVoitures = query.getResultList();
        return listeVoitures;
    }

}