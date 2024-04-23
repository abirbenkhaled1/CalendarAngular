package com.example.tp11.services;

import com.example.tp11.Entity.Client;
import com.example.tp11.Entity.Location;

import java.util.List;

public interface ClientServiceInterface {
    Client getClientByNom(String nom);
    List<Client> getAllClient();

    Client CreateClient(Client client);
    Client getClientById(long id );
    Client updateClient(Client client);
    Void deleteClient(Long id);

}
