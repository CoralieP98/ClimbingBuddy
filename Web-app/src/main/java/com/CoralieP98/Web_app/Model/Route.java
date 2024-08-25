package com.CoralieP98.Web_app.Model;

import com.CoralieP98.Web_app.Model.Exercice;
import com.CoralieP98.Web_app.Model.Session;
import com.CoralieP98.Web_app.Model.Technic;
import com.CoralieP98.Web_app.Model.Type;
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

    private float lenght;

    private Session session;

    private List<Technic> technics;

    private List<Exercice> exercices;

}
