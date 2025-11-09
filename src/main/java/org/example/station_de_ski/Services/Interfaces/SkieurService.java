package org.example.station_de_ski.Services.Interfaces;

import org.example.station_de_ski.Entities.Skieur;

import java.util.List;

public interface SkieurService {
    Skieur ajouterSkieur(Skieur skieur);
    Skieur getSkieurById(long id);
    Skieur modifierSkieur(Skieur skieur);
    void supprimerSkieur(long id);
    List<Skieur> getSkieurs();
}
