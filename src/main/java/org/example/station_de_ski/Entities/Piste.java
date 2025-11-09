package org.example.station_de_ski.Entities;

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
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String nomPiste;

    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private int longueur;
    private int pente;

    @ManyToMany(mappedBy = "pistes")
    private List<Skieur> skieurs;

}
