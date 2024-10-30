package com.CoralieP98.Web_app.Model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Data
public class Session {

    private int sessionId;

    private LocalDate date;

    private float duration;

    private  boolean warmUp;

    private Place place;

    private User user;

}
