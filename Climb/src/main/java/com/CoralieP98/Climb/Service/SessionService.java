package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Model.Route;
import com.CoralieP98.Climb.Model.Session;
import com.CoralieP98.Climb.Model.User;
import com.CoralieP98.Climb.Repository.RouteRepository;
import com.CoralieP98.Climb.Repository.SessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private final PlaceService placeService;

    private final SessionRepository sessionRepository;

    private final UserService userService;

    private final RouteRepository routeRepository;

    public SessionService(PlaceService placeService, SessionRepository sessionRepository, UserService userService, RouteRepository routeRepository) {
        this.placeService = placeService;
        this.sessionRepository = sessionRepository;
        this.userService = userService;

        this.routeRepository = routeRepository;
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

    public Session findLastSessionByUserIdList(int id) {
        Optional<List<Session>> optionalSessions = sessionRepository.findAllSessionByUserId(id);

        // Vérifier si la liste est présente et non vide
        if (optionalSessions.isPresent() && !optionalSessions.get().isEmpty()) {
            List<Session> sessions = optionalSessions.get();
            return sessions.get(sessions.size() - 1); // Retourner la dernière session
        }

        // Retourner null si aucune session n'est trouvée
        return null;
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

    @Transactional
    public void deleteSession(int sessionId) {
        Session session = findSessionById(sessionId);


        List<Route> routes = routeRepository.findAllRouteBySession(session).get();
        for (Route route : routes) {
            route.setSession(null);
            routeRepository.delete(route);
        }
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

//    public Session getLastSessionByUserId(int id) {
//        return sessionRepository.findLastByUserIdOrderByUserIdDesc(id).get();
//    }
}
