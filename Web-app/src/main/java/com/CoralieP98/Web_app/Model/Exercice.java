package com.CoralieP98.Web_app.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
public class Exercice {

    private int exerciceId;

    private String labelExercice;


    private Long cardId; //card etant une table mongo voir comment faire le lien


}
