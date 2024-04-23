package com.example.tp11.Repo;

import com.example.tp11.Entity.Client;
import com.example.tp11.Entity.Modele;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class ModeleRepoImp implements  ModeleRepoCustom{


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Modele getModeleByNom (String nom) {
        Query query = entityManager.createNativeQuery("SELECT c.* FROM Modele c WHERE c.nom LIKE ?", Modele.class);
        query.setParameter(1,nom+"%");
        return (Modele) query.getSingleResult();

    }
}
