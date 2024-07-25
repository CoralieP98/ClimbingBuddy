package com.CoralieP98.Climb.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int routeId;

    @ManyToOne
    private Type type;

    private boolean isSlab;

    private boolean isOverHang;

    private boolean isLead;

    private boolean isTopRope;

    private float lenght;

    @ManyToOne
    private  Session session;

    @ManyToMany
    private List<Technic> technics;

    @ManyToMany
    private List<Exercice> exercices;

}
