package com.example.tp11.Repo;

import com.example.tp11.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo  extends JpaRepository<Client,Long>, ClientRepoCustom {

}
