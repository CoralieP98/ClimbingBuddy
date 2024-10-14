package com.CoralieP98.Climb.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeId;

    private boolean isSlab;

    private boolean isOverHang;

    private boolean isLead;

    private boolean isTopRope;

    private boolean isARepeat;

    private float lenght;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "route_technique",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "technique_id")
    )
    private List<Technique> techniques;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "route_exercice",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "exercice_id")
    )
    private List<Exercice> exercices;

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Technique> getTechniques() {
        return techniques;
    }

    public void setTechniques(List<Technique> techniques) {
        this.techniques = techniques;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }
}
