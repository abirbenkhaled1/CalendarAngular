package com.example.tp11.Repo;

import com.example.tp11.Entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


public class ClientRepoImp implements ClientRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Client getClientByNom (String nom) {
        Query query = entityManager.createNativeQuery("SELECT c.* FROM Client c WHERE c.nom LIKE ?", Client.class);
        query.setParameter(1,nom+"%");
        return (Client) query.getSingleResult();

            }
            }
