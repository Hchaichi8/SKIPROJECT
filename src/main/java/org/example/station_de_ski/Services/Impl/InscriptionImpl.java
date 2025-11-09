package org.example.station_de_ski.Services.Impl;

import org.example.station_de_ski.Entities.Inscription;
import org.example.station_de_ski.Repositories.InscriptionRepository;
import org.example.station_de_ski.Services.Interfaces.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class InscriptionImpl implements InscriptionService {
    @Autowired
    InscriptionRepository InscriptionRepo;

    @Override
    public Inscription ajouterInscription(Inscription inscription) {
        return InscriptionRepo.save(inscription);
    }

    @Override
    public Inscription getInscriptionyId(long id) {
        return InscriptionRepo.findById(id).orElseThrow();
    }

    @Override
    public Inscription modifierInscription(Inscription inscription) {
        return InscriptionRepo.save(inscription);
    }

    @Override
    public void supprimerInscription(long id) {
        InscriptionRepo.deleteById(id);
    }

    @Override
    public List<Inscription> getInscription() {
        return InscriptionRepo.findAll();
    }
}
