package org.example.station_de_ski.Repositories;

import org.example.station_de_ski.Entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PisteRepository extends JpaRepository<Piste,Long> {
}
