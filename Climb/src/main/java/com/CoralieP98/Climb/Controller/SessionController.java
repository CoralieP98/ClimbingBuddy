package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Model.Session;
import com.CoralieP98.Climb.Service.SessionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("createSession")
    public Session createSession(@RequestBody Session session){
        sessionService.createSession(session);
        return session;
    }

    @GetMapping("findSessionById")
    public Session findSessionById(@RequestParam int sessionId){
        return sessionService.findSessionById(sessionId);
    }

    @PostMapping("findAllSessionByUserId")
    public List<Session> findAllSessionByUserId(@RequestParam int id){
        return sessionService.findAllSessionByUserId(id);
    }

    @PostMapping("findAllSessionsByPlaceId")
    public List<Session> findAllSessionsByPlaceId(@RequestParam int placeId){
        return sessionService.findAllSessionsByPlace(placeId);
    }

    @GetMapping("findSessionByDate")
    public Session findSessionByDate(@RequestParam Date date){
        return sessionService.findSessionByDate(date);
    }

    @DeleteMapping("deleteSession")
    public void deleteSession(@RequestParam int sessionId){
        sessionService.deleteSession(sessionId);
    }

    @PutMapping("updateSession")
    public Session updateSession(@RequestParam(name = "sessionId")int sessionId,@RequestBody Session session){
        return sessionService.updateSession(sessionId, session);
    }

    @GetMapping("getAllSessions")
    public List<Session> getAllSessions(){
        return sessionService.getAllSessions();
    }



}
