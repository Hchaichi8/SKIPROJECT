package org.example.station_de_ski.Controllers;

import org.example.station_de_ski.Entities.Abonnement;
import org.example.station_de_ski.Services.Interfaces.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Abonnement")
public class AbonnementController {
    @Autowired
    AbonnementService abonnementService;

    @PostMapping("/addAbonnement")
    public Abonnement addAbonnement(@RequestBody Abonnement a) {return abonnementService.ajouterAbonnement(a);}
    @PostMapping("/modifierAbonnement")
    public Abonnement modifierAbonnement(@RequestBody Abonnement a) {return abonnementService.modifierAbonnement(a);}
    @DeleteMapping("/supprimerAbonnement/{id}")
    public void supprimerAbonnement(@RequestBody long id) {abonnementService.supprimerAbonnement(id);}
    @GetMapping("/getAbonnement/{id}")
    public Abonnement getAbonnement(@RequestBody long id) {return abonnementService.getAbonnementById(id);}
    @GetMapping("/getAllAbonnements")
    public List<Abonnement> getAllAbonnements() {return abonnementService.getAbonnement();}
}
