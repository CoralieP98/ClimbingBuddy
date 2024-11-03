package com.CoralieP98.Web_app.Service.Client;

import com.CoralieP98.Web_app.Model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient("climb")
public interface ClimbFeignClient {

    @PostMapping(value = "/api/createUser", consumes = "application/json")
    public ResponseEntity<User> createUser(User user);

    @PostMapping(value = "/api/findUserByUserName", consumes = "application/json")
    public ResponseEntity<User> getUserByUserName (@RequestParam String email);

    @GetMapping(value = "/api/getAll", consumes = "application/json")
    public ResponseEntity<List<User>> getAllUsers();

    @GetMapping(value = "/api/findUserById", consumes = "application/json")
    public ResponseEntity<User> findUserById(@RequestParam int id);

    @PutMapping(value = "/api/updateUser", consumes = "application/json")
    public ResponseEntity<User> updateUser(@RequestParam int id, User user);

    @DeleteMapping(value = "/api/deleteUser", consumes = "application/json")
    public void deleteUser(@RequestParam int id);


// Session //////////////////////

    @PostMapping(value = "/api/createSession", consumes = "application/json")
    public ResponseEntity<Session> createSession(Session session);

    @GetMapping(value = "/api/findSessionById", consumes = "application/json")
    public ResponseEntity<Session> findSessionById(@RequestParam int sessionId);

    @PostMapping(value = "/api/findAllSessionByUserId", consumes = "application/json")
    public ResponseEntity<List<Session>> findAllSessionByUserId(@RequestParam int id);

    @PostMapping(value = "/api/findAllSessionsByPlaceIdAndUserId", consumes = "application/json")
    public ResponseEntity<List<Session>> findAllSessionsByPlaceIdAndUserId(@RequestParam int placeId, @RequestParam int id);

    @GetMapping(value = "/api/findSessionByDate", consumes = "application/json")
    public ResponseEntity<Session> findSessionByDate(@RequestParam String dateString);

    @DeleteMapping(value = "/api/deleteSession", consumes = "application/json")
    public void deleteSession(@RequestParam int sessionId);

    @PutMapping(value = "/api/updateSession", consumes = "application/json")
    public ResponseEntity<Session> updateSession(@RequestParam int sessionId, Session session);

    @GetMapping(value = "/api/getAllSessions", consumes = "application/json")
    public ResponseEntity<List<Session>> getAllSessions();


// Route //////////////////////

    @PostMapping(value = "/api/createRoute", consumes = "application/json")
    public ResponseEntity<Route> createRoute(Route route);

    @DeleteMapping(value = "/api/deleteRoute", consumes = "application/json")
    public void deleteRoute(@RequestParam int routeId);

    @PutMapping(value = "/api/updateRoute", consumes = "application/json")
    public ResponseEntity<Route> updateRoute(@RequestParam int routeId, Route route);

    @GetMapping(value = "/api/findRouteById", consumes = "application/json")
    public ResponseEntity<Route> findRouteByid(@RequestParam int routeId);

    @PostMapping(value = "/api/findAllRouteBySessionId", consumes = "application/json")
    public ResponseEntity<List<Route>> findAllRouteBySession(@RequestParam int sessionId);

    @PostMapping(value = "/api/findAllRouteByTypeId", consumes = "application/json")
    public ResponseEntity<List<Route>> findAllRouteByType(@RequestParam int typeId);

    @PostMapping(value = "/api/findAllRouteByGradeIdAndUserId", consumes = "application/json")
    public ResponseEntity<List<Route>> findAllRouteByGradeIdAndUserId(@RequestParam int gradeId, @RequestParam int id);

    @PostMapping(value = "/api/findAllRouteByTechniqueAndUserId", consumes = "application/json")
    public ResponseEntity<List<Route>> findAllRouteByTechnique(@RequestParam int techniqueId,@RequestParam int id);

    @PostMapping(value = "/api/findAllRouteByExerciceAndUserId", consumes = "application/json")
    public ResponseEntity<List<Route>> findAllRouteByExercice(@RequestParam int exerciceId,@RequestParam int id);

    @GetMapping(value = "/api/getAllRoutes", consumes = "application/json")
    public ResponseEntity<List<Route>> getAllRoutes();

    @PostMapping(value = "/api/getAllRoutesByUser", consumes = "application/json")
    public ResponseEntity<List<Route>> getAllRoutesByUser(@RequestParam int id);


// Type //////////////////////

    @GetMapping(value = "/api/getAll3Types", consumes = "application/json")
    public ResponseEntity<List<Type>> getAll3Types();

    @GetMapping(value = "/api/getTypeById", consumes = "application/json")
    public ResponseEntity<Type> getTypeById(@RequestParam int typeId);


// Place //////////////////////

    @PostMapping(value = "/api/createPlace", consumes = "application/json")
    public ResponseEntity<Place> createPlace(Place place);

    @GetMapping(value = "/api/findPlaceById", consumes = "application/json")
    public ResponseEntity<Place> findPlaceById(@RequestParam int placeId);

    @DeleteMapping(value = "/api/deletePlace", consumes = "application/json")
    public void deletePlace(@RequestParam int placeId);

    @PutMapping(value = "/api/updatePlace", consumes = "application/json")
    public ResponseEntity<Place> updatePlace(@RequestParam int placeId, Place place);

    @PostMapping(value = "/api/findFavoritePlacesByUserId", consumes = "application/json")
    public ResponseEntity<List<Place>> findFavoritePlaceById(@RequestParam int id);

    @GetMapping(value = "/api/getAllPlaces", consumes = "application/json")
    public ResponseEntity<List<Place>> getAllPlaces();


// Exercice //////////////////////

    @PostMapping(value = "/api/createExercice", consumes = "application/json")
    public ResponseEntity<Exercice> createExercice(Exercice exercice);

    @DeleteMapping(value = "/api/deleteExercice", consumes = "application/json")
    public void deleteExercice(@RequestParam int exerciceId);

    @PutMapping(value = "/api/updateExercice", consumes = "application/json")
    public ResponseEntity<Exercice> updateExercice(@RequestParam int exerciceId, Exercice exercice);

    @GetMapping(value = "/api/getAllExercices", consumes = "application/json")
    public ResponseEntity<List<Exercice>> getAllExercices();

    @GetMapping(value = "/api/findExerciceById", consumes = "application/json")
    public ResponseEntity<Exercice> findExerciceById(@RequestParam int exercieId);

    @GetMapping(value = "/api/findAllExercicesById", consumes = "application/json")
    public ResponseEntity<List<Exercice>> findAllExercicesById(@RequestParam List<Integer> exercicesIds);


// Technic //////////////////////

    @PostMapping(value = "/api/createTechnique", consumes = "application/json")
    public ResponseEntity<Technique> createTechnique(Technique technique);

    @DeleteMapping(value = "/api/deleteTechnique", consumes = "application/json")
    public void deleteTechnique(@RequestParam int technicId);

    @PutMapping(value = "/api/updateTechnique", consumes = "application/json")
    public ResponseEntity<Technique> updateTechnique(@RequestParam int technicId, Technique technique);

    @GetMapping(value = "/api/getAllTechniques", consumes = "application/json")
    public ResponseEntity<List<Technique>> getAllTechniques();

    @GetMapping(value = "/api/findTechniqueById", consumes = "application/json")
    public ResponseEntity<Technique> findTechniqueById(@RequestParam int technicId);

    @GetMapping(value = "/api/findAllTechniquesById", consumes = "application/json")
    public ResponseEntity<List<Technique>> findAllTechniquesById(@RequestParam List<Integer> techniqueIds);



// Profil //////////////////////

    @PostMapping(value = "/api/createProfil", consumes = "application/json")
    public ResponseEntity<Profil> createProfil(Profil profil);

    @PutMapping(value = "/api/updateProfil", consumes = "application/json")
    public ResponseEntity<Profil> updateProfil(@RequestParam int profilId, @RequestBody Profil profil);

    @GetMapping(value = "/api/getProfilById", consumes = "application/json")
    public ResponseEntity<Profil> getProfilById(@RequestParam int profilId);

    @DeleteMapping(value = "/api/deleteProfil", consumes = "application/json")
    public void deleteProfil(@RequestParam int profilId);

    @PostMapping(value = "/api/getProfilByUserId", consumes = "application/json")
    public ResponseEntity<Profil> getProfilByUserId(@RequestParam int id);


// Grade //////////////////////

    @GetMapping(value = "/api/getGradeById", consumes = "application/json")
    public ResponseEntity<Grade> getGradeById(@RequestParam int gradeId);

    @GetMapping(value = "/api/getAllGrades", consumes = "application/json")
    public ResponseEntity<List<Grade>> getAllGrades();


}
