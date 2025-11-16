package org.example.station_de_ski.Services.Impl;

import org.example.station_de_ski.Entities.Skieur;
import org.example.station_de_ski.Repositories.SkieurRepository;
import org.example.station_de_ski.Services.Interfaces.SkieurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkieurImpl implements SkieurService {
    @Autowired
    SkieurRepository SkieurRepo;

    @Override
    public Skieur ajouterSkieur(Skieur skieur) {
        return SkieurRepo.save(skieur);
    }

    @Override
    public Skieur getSkieurById(long id) {
        return SkieurRepo.findById(id).orElseThrow();
    }

    @Override
    public Skieur modifierSkieur(Skieur skieur) {
        return SkieurRepo.save(skieur);
    }

    @Override
    public void supprimerSkieur(long id) {
        SkieurRepo.deleteById(id);
    }

    @Override
    public List<Skieur> getSkieurs() {
        return SkieurRepo.findAll();
    }


}
