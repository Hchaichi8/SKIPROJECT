package org.example.station_de_ski.Services.Interfaces;

import org.example.station_de_ski.Entities.Abonnement;

import java.util.List;

public interface AbonnementService {

    Abonnement ajouterAbonnement(Abonnement abonnement);
    Abonnement getAbonnementById(long id);
    Abonnement modifierAbonnement(Abonnement abonnement);
    void supprimerAbonnement(long id);
    List<Abonnement> getAbonnement();
}
