package com.CoralieP98.Web_app.Model;

import lombok.Data;

import java.util.List;

@Data
public class Exercice {

    private int exerciceId;

    private String labelExercice;

    private List<Route> routes;

    private Long cardId; //card etant une table mongo voir comment faire le lien

    public Exercice() {
    }

    public Exercice(int exerciceId, String labelExercice, List<Route> routes, Long cardId) {
        this.exerciceId = exerciceId;
        this.labelExercice = labelExercice;
        this.routes = routes;
        this.cardId = cardId;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
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
