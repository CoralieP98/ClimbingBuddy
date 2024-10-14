package com.CoralieP98.Web_app.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    private int typeId;

    private String lapelType;

    public Type() {
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
