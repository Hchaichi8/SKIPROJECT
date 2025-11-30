package org.example.station_de_ski.Controllers;

import lombok.AllArgsConstructor;
import org.example.station_de_ski.Entities.Piste;
import org.example.station_de_ski.Services.Interfaces.PisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Piste")
public class PisteController {
    @Autowired
    private final PisteService pisteService;

    public PisteController(org.example.station_de_ski.Services.Interfaces.PisteService pisteService) {
        this.pisteService = pisteService;
    }

    @PostMapping("/addPiste")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.ajouterPiste(piste);
    }
    @PutMapping("/modifierPiste")
    public Piste modifierPiste(@RequestBody Piste piste) {
        return pisteService.modifierPiste(piste);
    }
    @DeleteMapping("/supprimerPiste/{id}")
    public void supprimerPiste(@PathVariable long id) {
        pisteService.supprimerPiste(id);
    }
    @GetMapping("/getPiste/{id}")
    public Piste getPiste(@PathVariable long id) {
        return pisteService.getPisteById(id);
    }
    @GetMapping("/getAllPistes")
    public List<Piste> getAllPistes() {
        return pisteService.getPiste();
    }
}