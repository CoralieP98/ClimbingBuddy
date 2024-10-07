package com.CoralieP98.Climb.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int routeId;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    private boolean isSlab;

    private boolean isOverHang;

    private boolean isLead;

    private boolean isTopRope;

    private boolean isARepeat;

    private float lenght;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private  Session session;

    @ManyToMany
    private List<Technic> technics;

    @ManyToMany
    private List<Exercice> exercices;

    public Route() {
    }

    public Route(int routeId, Type type, boolean isSlab, boolean isOverHang, boolean isLead, boolean isTopRope, boolean isARepeat, float lenght, Session session, List<Technic> technics, List<Exercice> exercices) {
        this.routeId = routeId;
        this.type = type;
        this.isSlab = isSlab;
        this.isOverHang = isOverHang;
        this.isLead = isLead;
        this.isTopRope = isTopRope;
        this.isARepeat = isARepeat;
        this.lenght = lenght;
        this.session = session;
        this.technics = technics;
        this.exercices = exercices;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isSlab() {
        return isSlab;
    }

    public void setSlab(boolean slab) {
        isSlab = slab;
    }

    public boolean isOverHang() {
        return isOverHang;
    }

    public void setOverHang(boolean overHang) {
        isOverHang = overHang;
    }

    public boolean isLead() {
        return isLead;
    }

    public void setLead(boolean lead) {
        isLead = lead;
    }

    public boolean isTopRope() {
        return isTopRope;
    }

    public void setTopRope(boolean topRope) {
        isTopRope = topRope;
    }

    public boolean isARepeat() {
        return isARepeat;
    }

    public void setARepeat(boolean ARepeat) {
        isARepeat = ARepeat;
    }

    public float getLenght() {
        return lenght;
    }

    public void setLenght(float lenght) {
        this.lenght = lenght;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Technic> getTechnics() {
        return technics;
    }

    public void setTechnics(List<Technic> technics) {
        this.technics = technics;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }
}
