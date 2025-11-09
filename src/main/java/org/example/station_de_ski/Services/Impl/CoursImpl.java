package org.example.station_de_ski.Services.Impl;

import org.example.station_de_ski.Entities.Cours;
import org.example.station_de_ski.Repositories.CoursRepository;
import org.example.station_de_ski.Services.Interfaces.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoursImpl implements CoursService {
    @Autowired
    CoursRepository CoursRepo;

    @Override
    public Cours ajouterCours(Cours cours) {
        return CoursRepo.save(cours);
    }

    @Override
    public Cours getCoursyId(long id) {
        return CoursRepo.findById(id).orElseThrow();
    }

    @Override
    public Cours modifierCours(Cours cours) {
        return CoursRepo.save(cours);
    }

    @Override
    public void supprimerCours(long id) {
        CoursRepo.deleteById(id);
    }

    @Override
    public List<Cours> getCours() {
        return CoursRepo.findAll();
    }
}
