package org.example.station_de_ski.Services.Interfaces;

import org.example.station_de_ski.Entities.Moniteur;

import java.util.List;

public interface MoniteurService {
    Moniteur ajouterMoniteur(Moniteur moniteur);
    Moniteur getMoniteurById(long id);
    Moniteur modifierMoniteur(Moniteur moniteur);
    void supprimerMoniteur(long id);
    List<Moniteur> getMoniteur();

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
}
