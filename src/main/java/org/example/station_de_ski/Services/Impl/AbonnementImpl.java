package org.example.station_de_ski.Services.Impl;

import org.example.station_de_ski.Entities.Abonnement;
import org.example.station_de_ski.Repositories.AbonnementRepository;
import org.example.station_de_ski.Services.Interfaces.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AbonnementImpl implements AbonnementService {
    @Autowired
    AbonnementRepository AbonnementRepo;

    @Override
    public Abonnement ajouterAbonnement(Abonnement abonnement) {
        return AbonnementRepo.save(abonnement);
    }

    @Override
    public Abonnement getAbonnementById(long id) {
        return AbonnementRepo.findById(id).orElseThrow();
    }

    @Override
    public Abonnement modifierAbonnement(Abonnement abonnement) {
        return AbonnementRepo.save(abonnement);
    }

    @Override
    public void supprimerAbonnement(long id) {
        AbonnementRepo.deleteById(id);

    }

    @Override
    public List<Abonnement> getAbonnement() {
        return AbonnementRepo.findAll();
    }
}
