package com.CoralieP98.Climb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int placeId;

    private String labelPlace;

    public Place() {
    }

    public Place(int placeId, String labelPlace) {
        this.placeId = placeId;
        this.labelPlace = labelPlace;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getLabelPlace() {
        return labelPlace;
    }

    public void setLabelPlace(String labelPlace) {
        this.labelPlace = labelPlace;
    }
}
