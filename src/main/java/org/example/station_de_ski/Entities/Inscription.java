package org.example.station_de_ski.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity

@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numInscription;
    private int numSemaine;

    @ManyToOne
    private Skieur skieur;

    @ManyToOne
    private Cours cours;

    public long getNumInscription() {
        return numInscription;
    }

    public void setNumInscription(long numInscription) {
        this.numInscription = numInscription;
    }

    public int getNumSemaine() {
        return numSemaine;
    }

    public void setNumSemaine(int numSemaine) {
        this.numSemaine = numSemaine;
    }

    public Skieur getSkieur() {
        return skieur;
    }

    public void setSkieur(Skieur skieur) {
        this.skieur = skieur;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
