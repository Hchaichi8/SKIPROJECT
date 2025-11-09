package org.example.station_de_ski.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;

    @OneToMany(mappedBy = "skieur")
    private List<Inscription> inscriptions;
    @OneToOne
    private Abonnement abonnement;
    @ManyToMany
    private List<Piste> pistes;;


}
