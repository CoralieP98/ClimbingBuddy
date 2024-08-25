package com.CoralieP98.Web_app.Model;


import lombok.Data;

import java.util.List;

@Data
public class Type {

    private int typeId;

    private String lapelType;

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
