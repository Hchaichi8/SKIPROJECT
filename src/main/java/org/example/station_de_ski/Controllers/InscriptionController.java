package org.example.station_de_ski.Controllers;

import org.example.station_de_ski.Entities.Inscription;
import org.example.station_de_ski.Services.Interfaces.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Inscription")
public class InscriptionController {
    @Autowired
    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping("/addInscription")
    public Inscription addInscription(@RequestBody Inscription i) {return inscriptionService.ajouterInscription(i);}
    @PostMapping("/modifierInscription")
    public Inscription modifierInscription(@RequestBody Inscription i) {return inscriptionService.modifierInscription(i);}
    @DeleteMapping("/supprimerInscription/{id}")
    public void supprimerInscription(@RequestBody long id) {inscriptionService.supprimerInscription(id);}
    @GetMapping("/getInscription/{id}")
    public Inscription getInscription(@RequestBody long id) {return inscriptionService.getInscriptionyId(id);}
    @GetMapping("/getAllInscriptions")
    public List<Inscription> getAllInscriptions() {return inscriptionService.getInscription();}
}
