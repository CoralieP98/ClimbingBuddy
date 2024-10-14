package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Model.Session;
import com.CoralieP98.Climb.Repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void createSession(Session session){
        sessionRepository.save(session);
    }

    public Session findSessionById(int sessionId) {
        return sessionRepository.findSessionBySessionId(sessionId).get();
    }

    public List<Session> findAllSessionByUserId(int id) {
        return sessionRepository.findAllSessionByUserId(id).get();
    }

//    public List<Session> findAllSessionsByPlace(Place place) {
//        return sessionRepository.findAllSessionsByPlace(place).get();
//    }

    public Session findSessionByDate(Date date) {
        return sessionRepository.findSessionByDate(date).get();
    }

    public void deleteSession(int sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    public Session updateSession(int sessionId, Session session) {
        session.setSessionId(sessionId);
        return sessionRepository.save(session);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
}
