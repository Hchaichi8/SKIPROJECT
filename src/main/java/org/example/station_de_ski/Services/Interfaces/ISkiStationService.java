package org.example.station_de_ski.Services.Interfaces;

import org.example.station_de_ski.Entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISkiStationService {

    Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkieur);
    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription,Long numSkieur, Long numCours);
    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor , Supports support);



}
