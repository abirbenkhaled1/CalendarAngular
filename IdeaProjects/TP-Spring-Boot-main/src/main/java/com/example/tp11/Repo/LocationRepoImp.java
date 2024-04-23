package com.example.tp11.Repo;

import com.example.tp11.Entity.Client;
import com.example.tp11.Entity.Location;
import com.example.tp11.Entity.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository

public class LocationRepoImp implements LocationRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Location findLocationsByClient(Client client ){
        Query query = entityManager.createNativeQuery("SELECT * FROM location ", Location.class);
//        query.setParameter(1,id+"%");
        return (Location) query.getSingleResult();    }


    @Transactional
    public Location findLocationByVoiture(Voiture voiture) {
        Query query = entityManager.createNativeQuery("SELECT * FROM location", Location.class);
//        query.setParameter(1,id+"%");
        return (Location) query;    }
}
