package com.CoralieP98.Climb.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int placeId;

    @ManyToOne
    private List<Session> sessions;

    private String labelPlace;

    public Place() {
    }

    public Place(int placeId, List<Session> sessions, String labelPlace) {
        this.placeId = placeId;
        this.sessions = sessions;
        this.labelPlace = labelPlace;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getLabelPlace() {
        return labelPlace;
    }

    public void setLabelPlace(String labelPlace) {
        this.labelPlace = labelPlace;
    }
}
