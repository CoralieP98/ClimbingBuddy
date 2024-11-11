package com.CoralieP98.stats.Model;

import lombok.Data;


@Data
public class Exercice {

    private int exerciceId;

    private String labelExercice;


    private Long cardId; //card etant une table mongo voir comment faire le lien


}
