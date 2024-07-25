package com.CoralieP98.Climb.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int placeId;

    @OneToMany
    private Session session;

    private String labelPlace;

    public Place() {
    }

    public Place(int placeId, Session session, String labelPlace) {
        this.placeId = placeId;
        this.session = session;
        this.labelPlace = labelPlace;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getLabelPlace() {
        return labelPlace;
    }

    public void setLabelPlace(String labelPlace) {
        this.labelPlace = labelPlace;
    }
}
