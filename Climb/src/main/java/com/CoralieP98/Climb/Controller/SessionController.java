package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Model.Session;
import com.CoralieP98.Climb.Service.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @PostMapping("findAllSessionsByPlaceIdAndUserId")
    public List<Session> findAllSessionsByPlaceIdAndUserId(@RequestParam int placeId, @RequestParam int id){
        return sessionService.findAllSessionsByPlaceAndUserId(placeId,id);
    }

    @GetMapping("findSessionByDate")
    public Session findSessionByDate(@RequestParam String dateString) throws ParseException {
        return sessionService.findSessionByDate(dateString);
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

//    @GetMapping("getLastSessionByUserId")
//    public Session getLastSessionByUserId(@RequestParam int id){
//        return sessionService.getLastSessionByUserId(id);
//    }

    @GetMapping("getListLastSession")
    public ResponseEntity<Session> getListLastSession(@RequestParam int id){
        Session lastSession = sessionService.findLastSessionByUserIdList(id);

        if (lastSession == null) {
            // Retourner une réponse 404 si aucune session n'est trouvée
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Retourner la session si elle existe
        return ResponseEntity.ok(lastSession);
    }



}
