package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Model.Session;
import com.CoralieP98.Climb.Model.User;
import com.CoralieP98.Climb.Repository.SessionRepository;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SessionService {

    private final PlaceService placeService;

    private final SessionRepository sessionRepository;

    private final UserService userService;

    public SessionService(PlaceService placeService, SessionRepository sessionRepository, UserService userService) {
        this.placeService = placeService;
        this.sessionRepository = sessionRepository;
        this.userService = userService;
    }

    public void createSession(Session session){
        session.setPlace(placeService.findPlaceById(session.getPlace().getPlaceId()));
        session.setUser(userService.findUserById(session.getUser().getId()));
        sessionRepository.save(session);
    }

    public Session findSessionById(int sessionId) {
        return sessionRepository.findSessionBySessionId(sessionId).get();
    }

    public List<Session> findAllSessionByUserId(int id) {
        return sessionRepository.findAllSessionByUserId(id).get();
    }


    public List<Session> findAllSessionsByPlaceAndUserId(int placeId, int id) {
        User user = userService.findUserById(id);
        Place place = placeService.findPlaceById(placeId);
        return sessionRepository.findAllSessionsByPlaceAndUser(place, user).get();
    }

    public Session findSessionByDate(String dateString) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return sessionRepository.findSessionByDate(date).get();
    }

    public void deleteSession(int sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    public Session updateSession(int sessionId, Session session) {
        session.setPlace(placeService.findPlaceById(session.getPlace().getPlaceId()));
        session.setUser(userService.findUserById(session.getUser().getId()));
        session.setSessionId(sessionId);
        return sessionRepository.save(session);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
}
