package com.CoralieP98.stats.Model;

import lombok.Data;

import java.util.List;

@Data
public class Route {

    private int routeId;

    private Type type;

    private boolean isSlab;

    private boolean isOverHang;

    private boolean isLead;

    private boolean isTopRope;

    private boolean isARepeat;

    private boolean isFlash;

    private float lenght;

    private String routeName;

    private User user;

    private Grade grade;

    private Session session;

    private List<Technique> techniques;

    private List<Exercice> exercices;

}
