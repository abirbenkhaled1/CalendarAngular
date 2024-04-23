package com.example.tp11.Repo;

import com.example.tp11.Entity.Modele;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeleRepo  extends JpaRepository<Modele,Long>, ModeleRepoCustom{
}
