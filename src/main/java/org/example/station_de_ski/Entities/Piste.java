package org.example.station_de_ski.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
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


    public Long getNumPiste() { return numPiste; }
    public void setNumPiste(Long numPiste) { this.numPiste = numPiste; }

    public String getNomPiste() { return nomPiste; }
    public void setNomPiste(String nomPiste) { this.nomPiste = nomPiste; }

    public Couleur getCouleur() { return couleur; }
    public void setCouleur(Couleur couleur) { this.couleur = couleur; }

    public int getLongueur() { return longueur; }
    public void setLongueur(int longueur) { this.longueur = longueur; }

    public int getPente() { return pente; }
    public void setPente(int pente) { this.pente = pente; }

    public List<Skieur> getSkieurs() { return skieurs; }
    public void setSkieurs(List<Skieur> skieurs) { this.skieurs = skieurs; }

}
