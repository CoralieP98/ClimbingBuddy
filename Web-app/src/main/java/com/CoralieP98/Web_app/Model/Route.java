package com.CoralieP98.Web_app.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    private int routeId;

    private Type type;

    private boolean isSlab;

    private boolean isOverHang;

    private boolean isLead;

    private boolean isTopRope;

    private boolean isARepeat;

    private float lenght;

    private Session session;

    private List<Technique> techniques;

    private List<Exercice> exercices;

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
