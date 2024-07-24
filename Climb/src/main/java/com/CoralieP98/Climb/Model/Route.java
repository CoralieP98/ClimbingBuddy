package com.CoralieP98.Climb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int RouteId;

//    private int typeId;

    private boolean isSlab;

    private boolean isOverHang;

    private boolean isLead;

    private boolean isTopRope;

    private float lenght;

}
