package com.example.tp11.services;

import com.example.tp11.Entity.Client;
import com.example.tp11.Repo.ClientRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class ClientService implements ClientServiceInterface{


        @Autowired
        private  ClientRepo clientRepository;


    @Override
    public Client getClientByNom(String nom) {
        return clientRepository.getClientByNom(nom);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client CreateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client updateClient(Client client) {

        return clientRepository.saveAndFlush(client);
    }

    @Override
    public Void deleteClient(Long id) {clientRepository.deleteById(id);
        return null;
    }


}
