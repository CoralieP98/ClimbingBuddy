package com.CoralieP98.Web_app.Model;

import com.CoralieP98.Web_app.Model.Session;
import lombok.Data;

import java.util.List;

@Data
public class Place {

    private int placeId;

    private List<Session> sessions;

    private User user;

    private String labelPlace;

    public Place() {
    }

    public Place(int placeId, List<Session> sessions, User user, String labelPlace) {
        this.placeId = placeId;
        this.sessions = sessions;
        this.user = user;
        this.labelPlace = labelPlace;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
