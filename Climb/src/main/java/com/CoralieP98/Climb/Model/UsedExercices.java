package com.CoralieP98.Climb.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class UsedExercices {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsedExercices;

    @ManyToOne
    private Exercice exercice;

    @ManyToOne
    private Route route;

    //Not so sure about this! !!! meh
}
