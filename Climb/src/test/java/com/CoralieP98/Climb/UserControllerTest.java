package com.CoralieP98.Climb;

import com.CoralieP98.Climb.Controller.UserController;
import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Model.Session;
import com.CoralieP98.Climb.Model.User;
import com.CoralieP98.Climb.Repository.PlaceRepository;
import com.CoralieP98.Climb.Repository.SessionRepository;
import com.CoralieP98.Climb.Repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private PlaceRepository placeRepository;



    @BeforeEach
    public void setUp() {
//        userRepository.deleteAll();
        Session session = sessionRepository.save(new Session());
        List<Session> sessions = new ArrayList<>();
        sessions.add(session);
        Place place = placeRepository.save(new Place());
        List<Place> places = new ArrayList<>();
        places.add(place);
        User newUser = new User(0,"meh","m","meh@meh.m", sessions, places);
        userController.createUser(newUser);
    }


    @Test
    public void createUser() {
        assertThat(userController
                .getUserByUserName("meh@meh.m") != null).isEqualTo(true);
    }

    @Test
    public void deleteUser() {
        Session session = sessionRepository.save(new Session());
        List<Session> sessions = new ArrayList<>();
        sessions.add(session);
        Place place = placeRepository.save(new Place());
        List<Place> places = new ArrayList<>();
        places.add(place);
        User user = new User(0,"meh","m","meh@h.m", sessions, places);
        user.getId();
        userController.deleteUser(user.getId());

        assertThat(userRepository.existsById(user.getId())).isFalse();
    }



}
