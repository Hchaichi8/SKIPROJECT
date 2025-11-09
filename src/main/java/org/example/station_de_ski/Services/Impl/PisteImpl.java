package org.example.station_de_ski.Services.Impl;

import org.example.station_de_ski.Entities.Piste;
import org.example.station_de_ski.Repositories.PisteRepository;
import org.example.station_de_ski.Services.Interfaces.PisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PisteImpl implements PisteService {
    @Autowired
    PisteRepository PisteRepo;

    @Override
    public Piste ajouterPiste(Piste piste) {
        return PisteRepo.save(piste);
    }

    @Override
    public Piste getPisteById(long id) {
        return PisteRepo.findById(id).orElseThrow();
    }

    @Override
    public Piste modifierPiste(Piste piste) {
        return PisteRepo.save(piste);
    }

    @Override
    public void supprimerPiste(long id) {
        PisteRepo.deleteById(id);
    }

    @Override
    public List<Piste> getPiste() {
        return PisteRepo.findAll();
    }
}
