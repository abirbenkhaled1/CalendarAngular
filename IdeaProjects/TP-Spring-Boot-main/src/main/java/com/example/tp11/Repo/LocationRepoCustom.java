package com.example.tp11.Repo;

import com.example.tp11.Entity.Client;
import com.example.tp11.Entity.Location;
import com.example.tp11.Entity.Voiture;

public interface LocationRepoCustom {
    Location  findLocationsByClient (Client client);
    Location findLocationByVoiture(Voiture voiture);

}
