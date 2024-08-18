package com.CoralieP98.Climb.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sessionId;

    private Date date;

    private float duration;

    private  boolean warmUp;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Route> routes;

    public Session() {
    }

    public Session(int sessionId, Date date, float duration, boolean warmUp, Place place, User user) {
        this.sessionId = sessionId;
        this.date = date;
        this.duration = duration;
        this.warmUp = warmUp;
        this.place = place;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public boolean isWarmUp() {
        return warmUp;
    }

    public void setWarmUp(boolean warmUp) {
        this.warmUp = warmUp;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
