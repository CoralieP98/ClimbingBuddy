package com.CoralieP98.Web_app.Model;

import com.CoralieP98.Web_app.Model.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    private int placeId;

    private User user;

    private String labelPlace;

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLabelPlace() {
        return labelPlace;
    }

    public void setLabelPlace(String labelPlace) {
        this.labelPlace = labelPlace;
    }
}
