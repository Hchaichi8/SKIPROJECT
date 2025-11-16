package org.example.station_de_ski.Services.Interfaces;

import org.example.station_de_ski.Entities.Inscription;

import java.util.List;

public interface InscriptionService {
    Inscription ajouterInscription(Inscription inscription);
    Inscription getInscriptionyId(long id);
    Inscription modifierInscription(Inscription inscription);
    void supprimerInscription(long id);
    List<Inscription> getInscription();


}
