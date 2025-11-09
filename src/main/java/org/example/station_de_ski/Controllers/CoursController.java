package org.example.station_de_ski.Controllers;

import org.example.station_de_ski.Entities.Cours;
import org.example.station_de_ski.Services.Interfaces.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Cours")
public class CoursController {
    @Autowired
    CoursService coursService;

    @PostMapping("/addCours")
    public Cours addCours(@RequestBody Cours c) {return coursService.ajouterCours(c);}
    @PostMapping("/modifierCours")
    public Cours modifierCours(@RequestBody Cours c) {return coursService.modifierCours(c);}
    @DeleteMapping("/supprimerCours/{id}")
    public void supprimerCours(@RequestBody long id) {coursService.supprimerCours(id);}
    @GetMapping("/getCours/{id}")
    public Cours getCours(@RequestBody long id) {return coursService.getCoursyId(id);}
    @GetMapping("/getAllCours")
    public List<Cours> getAllCours() {return coursService.getCours();}
}
