package org.example.station_de_ski.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCours;
    private int niveau;
    private TypeCours typeCours;
    private Supports support;
    private float prix;
    private int creneau;
    @OneToMany(mappedBy = "cours")
    private List<Inscription> inscriptions;
    @ManyToOne
    private Moniteur moniteur;
}
