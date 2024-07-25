package com.CoralieP98.Climb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Exercice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int exerciceId;

    private String labelExercice;

    private Long cardId; //card etant une table mongo voir comment faire le lien

    public Exercice() {
    }

    public Exercice(int exerciceId, String labelExercice, Long cardId) {
        this.exerciceId = exerciceId;
        this.labelExercice = labelExercice;
        this.cardId = cardId;
    }

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
