package org.example.station_de_ski.Services.Impl;

import org.example.station_de_ski.Entities.Moniteur;
import org.example.station_de_ski.Repositories.MoniteurRepository;
import org.example.station_de_ski.Services.Interfaces.MoniteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MoniteurImpl implements MoniteurService {

    @Autowired
    MoniteurRepository MoniteurRepo;
    @Override
    public Moniteur ajouterMoniteur(Moniteur moniteur) {
        return MoniteurRepo.save(moniteur);
    }

    @Override
    public Moniteur getMoniteurById(long id) {
        return MoniteurRepo.findById(id).orElseThrow();
    }

    @Override
    public Moniteur modifierMoniteur(Moniteur moniteur) {
        return MoniteurRepo.save(moniteur);
    }

    @Override
    public void supprimerMoniteur(long id) {
        MoniteurRepo.deleteById(id);
    }

    @Override
    public List<Moniteur> getMoniteur() {
        return MoniteurRepo.findAll();
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        return null;
    }
}
