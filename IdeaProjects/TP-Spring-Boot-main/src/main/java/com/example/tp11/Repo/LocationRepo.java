package com.example.tp11.Repo;

import com.example.tp11.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location,Long>, LocationRepoCustom {



}
