package org.example.station_de_ski.Services.Interfaces;

import org.example.station_de_ski.Entities.Piste;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PisteService {
    Piste ajouterPiste(Piste piste);
    Piste getPisteById(long id);
    Piste modifierPiste(Piste piste);
    void supprimerPiste(long id);
    List<Piste> getPiste();
}
