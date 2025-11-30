package org.example.station_de_ski.Services.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.station_de_ski.Entities.*;
import org.example.station_de_ski.Repositories.*;
import org.example.station_de_ski.Services.Interfaces.ISkiStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
@Service
public class ISkiStationServiceAvanceImpl implements ISkiStationService {

    @Autowired
    AbonnementRepository AbonnementRepo;
    @Autowired
    CoursRepository CoursRepo;
    @Autowired
    InscriptionRepository InscriptionRepo;
    @Autowired
    MoniteurRepository MoniteurRepo;
    @Autowired
    PisteRepository PisteRepo;
    @Autowired
    SkieurRepository SkieurRepo;
    @Autowired
    private InscriptionRepository inscriptionRepository;


    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkieur) {
        Skieur skieur = SkieurRepo.findById(numSkieur).orElseThrow(() -> new RuntimeException("Skieur introuvable"));

        inscription.setSkieur(skieur);

        return InscriptionRepo.save(inscription);
    }

    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Inscription inscription = InscriptionRepo.findById(numRegistration)
                .orElseThrow(() -> new RuntimeException("Inscription introuvable"));

        Cours cours = CoursRepo.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Cours introuvable"));

        inscription.setCours(cours);
        return InscriptionRepo.save(inscription);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = SkieurRepo.findById(numSkieur).orElseThrow();
        Piste piste = PisteRepo.findById(numPiste).orElseThrow();

        skieur.getPistes().add(piste);
        return SkieurRepo.save(skieur);
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours = CoursRepo.findById(numCourse).orElseThrow();

        try{
            moniteur.getCours().add(cours);
        }catch (NullPointerException exception){
            Set<Cours> CoursList = new HashSet<>();
            CoursList.add(cours);
            moniteur.setCours(CoursList);
        }

        return MoniteurRepo.save(moniteur);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        return null;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return SkieurRepo.findByAbonnement_TypeAbon(typeAbonnement);
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return new TreeSet<>(
                AbonnementRepo.findByTypeAbonOrderByDateDebutAsc(type)
        );
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return AbonnementRepo.findByDateDebutBetween(startDate, endDate);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur = SkieurRepo.findById(numSkieur).orElseThrow();
        Cours cours = CoursRepo.findById(numCours).orElseThrow();

        inscription.setSkieur(skieur);
        inscription.setCours(cours);

        return InscriptionRepo.save(inscription);
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Supports support) {
        return List.of();
    }

    @Scheduled(cron = "0 0 8 * * *")
    @Override
    public void retrieveAbonnement(){
        LocalDate today = LocalDate.now();
        LocalDate sevenDayLater = today.plusDays(7);

        List<Abonnement> abonnementExpired = AbonnementRepo.findByDateFinBetween(today, sevenDayLater);
        abonnementExpired.forEach(s -> {
            System.out.println("Abonnement N° : " + s.getNumAbon());
            System.out.println("Skieur : " + s.getSkieur().getNumSkieur() + " | "
                    + s.getSkieur().getNomS() + " "
                    + s.getSkieur().getPrenomS());
            System.out.println("Date d'expiration : " + s.getDateFin());

        });
    }

    @Scheduled(cron = "0 0 9 1 * *")
    public void showMonthlyRecurringRevenue() {
        Float revenue = AbonnementRepo.recurringRevenueByTypeSubEquals(TypeAbonnement.MENSUEL)
                + AbonnementRepo.recurringRevenueByTypeSubEquals(TypeAbonnement.SEMESTRIEL)/6
                + AbonnementRepo.recurringRevenueByTypeSubEquals(TypeAbonnement.ANNUEL)/12;
        log.info("Monthly Revenue = " + revenue);
    }
}
