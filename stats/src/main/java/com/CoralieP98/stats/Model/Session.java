package com.CoralieP98.stats.Model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Session {

    private int sessionId;

    private LocalDate date;

    private float duration;

    private  boolean warmUp;

    private Place place;

    private User user;

}
