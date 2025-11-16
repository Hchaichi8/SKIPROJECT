package org.example.station_de_ski.Repositories;

import org.example.station_de_ski.Entities.Skieur;
import org.example.station_de_ski.Entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur,Long> {

    List<Skieur> findByAbonnement_TypeAbon(TypeAbonnement type);

}
