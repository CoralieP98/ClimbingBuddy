package com.CoralieP98.Web_app.Model;


import lombok.Data;

import java.util.List;

@Data
public class Technic {

    private int technicId;

    private String labelTechnic;

    private List<Route> routes;

    private Long cardId; //card etant une table mongo voir comment faire le lien

    public Technic() {
    }

    public Technic(int technicId, String labelTechnic, List<Route> routes, Long cardId) {
        this.technicId = technicId;
        this.labelTechnic = labelTechnic;
        this.routes = routes;
        this.cardId = cardId;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public int getTechnicId() {
        return technicId;
    }

    public void setTechnicId(int technicId) {
        this.technicId = technicId;
    }

    public String getLabelTechnic() {
        return labelTechnic;
    }

    public void setLabelTechnic(String labelTechnic) {
        this.labelTechnic = labelTechnic;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
}
