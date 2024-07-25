package com.CoralieP98.Climb.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int typeId;

    private String lapelType;

    public Type() {
    }

    public Type(int typeId, String lapelType) {
        this.typeId = typeId;
        this.lapelType = lapelType;
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
