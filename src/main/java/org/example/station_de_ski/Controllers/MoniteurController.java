package org.example.station_de_ski.Controllers;

import org.example.station_de_ski.Entities.Moniteur;
import org.example.station_de_ski.Services.Interfaces.MoniteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Moniteur")
public class MoniteurController {
    @Autowired
    MoniteurService moniteurService;

    @PostMapping("/addMoniteur")
    public Moniteur addMoniteur(@RequestBody Moniteur m) {return moniteurService.ajouterMoniteur(m);}
    @PostMapping("/modifierMoniteur")
    public Moniteur modifierMoniteur(@RequestBody Moniteur m) {return moniteurService.modifierMoniteur(m);}
    @DeleteMapping("/supprimerMoniteur/{id}")
    public void supprimerMoniteur(@RequestBody long id) {moniteurService.supprimerMoniteur(id);}
    @GetMapping("/getMoniteur/{id}")
    public Moniteur getMoniteur(@RequestBody long id) {return moniteurService.getMoniteurById(id);}
    @GetMapping("/getAllMoniteurs")
    public List<Moniteur> getAllMoniteurs() {return moniteurService.getMoniteur();}
}
