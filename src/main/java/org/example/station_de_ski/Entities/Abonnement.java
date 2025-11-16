package org.example.station_de_ski.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numAbon;
    private LocalDate dateDebut;

    public Skieur getSkieur() {
        return skieur;
    }

    public void setSkieur(Skieur skieur) {
        this.skieur = skieur;
    }

    public TypeAbonnement getTypeAbon() {
        return typeAbon;
    }

    public void setTypeAbon(TypeAbonnement typeAbon) {
        this.typeAbon = typeAbon;
    }

    public float getPrixAbon() {
        return prixAbon;
    }

    public void setPrixAbon(float prixAbon) {
        this.prixAbon = prixAbon;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public long getNumAbon() {
        return numAbon;
    }

    public void setNumAbon(long numAbon) {
        this.numAbon = numAbon;
    }

    private LocalDate dateFin;
    private float prixAbon;
    private TypeAbonnement typeAbon;

    @OneToOne(mappedBy = "abonnement")
    private Skieur skieur;
}
