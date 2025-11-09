package org.example.station_de_ski.Services.Interfaces;

import org.example.station_de_ski.Entities.Cours;

import java.util.List;

public interface CoursService {
    Cours ajouterCours(Cours cours);
    Cours getCoursyId(long id);
    Cours modifierCours(Cours cours);
    void supprimerCours(long id);
    List<Cours> getCours();
}
