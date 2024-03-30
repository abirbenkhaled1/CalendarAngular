package com.example.tp11.services;

import com.example.tp11.Entity.Modele;
import com.example.tp11.Repo.ModeleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ModeleService implements ModeleServiceInterface{

    @Autowired
    private ModeleRepo modeleRepository;

    @Override
    public Modele getModeleByNom(String nom) {
        return modeleRepository.getModeleByNom(nom);   }

    @Override
    public List<Modele> getAllModele() {
        return modeleRepository.findAll();
    }

    @Override
    public Modele CreateModele(Modele modele) {
        return modeleRepository.save(modele);
    }

    @Override
    public Optional<Modele> getModeleById(long id) {
        return modeleRepository.findById(id);
    }

    @Override
    public Modele updateModele(Modele modele) {
        return modeleRepository.saveAndFlush(modele);
    }

    @Override
    public Void  deleteModele(Long id) {
         modeleRepository.deleteById(id);
        return null;

    }
}
