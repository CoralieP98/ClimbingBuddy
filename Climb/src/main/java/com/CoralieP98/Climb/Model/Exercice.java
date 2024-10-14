package com.CoralieP98.Climb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Exercice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exerciceId;

    private String labelExercice;

    private Long cardId; //card etant une table mongo voir comment faire le lien //via webapp ???

    public int getExerciceId() {
        return exerciceId;
    }

    public void setExerciceId(int exerciceId) {
        this.exerciceId = exerciceId;
    }

    public String getLabelExercice() {
        return labelExercice;
    }

    public void setLabelExercice(String labelExercice) {
        this.labelExercice = labelExercice;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
}
