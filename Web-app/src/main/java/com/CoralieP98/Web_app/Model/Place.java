package com.CoralieP98.Web_app.Model;

import com.CoralieP98.Web_app.Model.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

public class Place {

    private int placeId;

    private User user;

    private String labelPlace;

}
