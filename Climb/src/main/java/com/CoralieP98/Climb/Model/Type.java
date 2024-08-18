package com.CoralieP98.Climb.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int typeId;

    private String lapelType;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Route> routesOfOneType;

    public Type() {
    }

    public Type(int typeId, String lapelType, List<Route> routesOfOneType) {
        this.typeId = typeId;
        this.lapelType = lapelType;
        this.routesOfOneType = routesOfOneType;
    }

    public List<Route> getRoutesOfOneType() {
        return routesOfOneType;
    }

    public void setRoutesOfOneType(List<Route> routesOfOneType) {
        this.routesOfOneType = routesOfOneType;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getLapelType() {
        return lapelType;
    }

    public void setLapelType(String lapelType) {
        this.lapelType = lapelType;
    }
}
