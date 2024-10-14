package com.CoralieP98.Web_app.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Exercice {

    private int exerciceId;

    private String labelExercice;


    private Long cardId; //card etant une table mongo voir comment faire le lien

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
