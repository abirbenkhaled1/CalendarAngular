package com.example.tp11.services;

import com.example.tp11.Entity.Voiture;
import com.example.tp11.Repo.ClientRepo;
import com.example.tp11.Repo.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService implements VoitureServiceInterface {

    @Autowired
    private VoitureRepo voitureRepository;


    @Override
    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture CreateVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Override
    public Voiture getVoitureById(long id) {
        return  voitureRepository.findById(id).get();
    }

    @Override
    public Voiture updateVoiture(Voiture voiture) {
        return voitureRepository.saveAndFlush(voiture);
    }

    @Override
    public Void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
        return null;
    }
}
