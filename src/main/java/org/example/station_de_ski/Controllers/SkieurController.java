package org.example.station_de_ski.Controllers;

import org.example.station_de_ski.Entities.Skieur;
import org.example.station_de_ski.Services.Interfaces.SkieurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Skieur")
public class SkieurController {
    @Autowired
    SkieurService skieurService;


    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur skieur) {return skieurService.ajouterSkieur(skieur);}
    @PostMapping("/modifierSkieur")
    public Skieur modifierSkieur(@RequestBody Skieur skieur) {return skieurService.modifierSkieur(skieur);}
    @DeleteMapping("/supprimerSkieur/{id}")
    public void supprimerSkieur(@RequestBody long id) {skieurService.supprimerSkieur(id);}
    @GetMapping("/getSkieur/{id}")
    public Skieur getSkieur(@RequestBody long id) {return skieurService.getSkieurById(id);}
    @GetMapping("/getAllSkieurs")
    public List<Skieur> getAllSkieurs() {return skieurService.getSkieurs();}
}
