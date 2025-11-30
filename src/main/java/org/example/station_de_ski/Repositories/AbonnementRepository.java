package org.example.station_de_ski.Repositories;

import org.example.station_de_ski.Entities.Abonnement;
import org.example.station_de_ski.Entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {

    List<Abonnement> findByTypeAbonOrderByDateDebutAsc(TypeAbonnement type);
    List<Abonnement> findByDateDebutBetween(LocalDate startDate, LocalDate endDate);

    List<Abonnement> findByDateFinBetween(LocalDate startDate, LocalDate endDate);

    @Query("select (sum(s.prixAbon))/(count(s)) from Abonnement s where s.typeAbon = ?1")
    Float recurringRevenueByTypeSubEquals(TypeAbonnement typeSub);


}
