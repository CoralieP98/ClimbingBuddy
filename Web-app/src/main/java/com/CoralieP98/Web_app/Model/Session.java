package com.CoralieP98.Web_app.Model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Session {

    private int sessionId;

    private Date date;

    private float duration;

    private  boolean warmUp;

    private Place place;

    private User user;

}
