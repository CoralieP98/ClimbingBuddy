package com.CoralieP98.Web_app.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private float lenght;

    private Session session;

    private List<Technique> techniques;

    private List<Exercice> exercices;

}
