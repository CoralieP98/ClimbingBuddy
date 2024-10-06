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

    @PostMapping(value = "/api/findAllSessionByPlaceId", consumes = "application/json")
    public ResponseEntity<List<Session>> findAllSessionByPlaceId(@RequestParam int placeId);

    @GetMapping(value = "/api/findSessionByDate", consumes = "application/json")
    public ResponseEntity<Session> findSessionByDate(@RequestParam Date date);

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
    public ResponseEntity<List<Route>> findAllRouteBySessionId(@RequestParam int sessionId);

    @PostMapping(value = "/api/findAllRouteByTypeId", consumes = "application/json")
    public ResponseEntity<List<Route>> findAllRouteByTypeId(@RequestParam int typeId);

    @PostMapping(value = "/api/findAllRouteByTechnicId", consumes = "application/json")
    public ResponseEntity<List<Route>> findAllRouteByTechnicId(@RequestParam int technicId);

    @PostMapping(value = "/api/findAllRouteByExerciceId", consumes = "application/json")
    public ResponseEntity<List<Route>> findAllRouteByExerciceId(@RequestParam int exerciceId);

    @GetMapping(value = "/api/getAllRoutes", consumes = "application/json")
    public ResponseEntity<List<Route>> getAllRoutes();


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

    @PostMapping(value = "/api/getAllExercicesByRouteId", consumes = "application/json")
    public ResponseEntity<List<Exercice>> getAllExercicesByRouteId(@RequestParam int routeId);


// Technic //////////////////////

    @PostMapping(value = "/api/createTechnic", consumes = "application/json")
    public ResponseEntity<Technic> createTechnic(Technic technic);

    @DeleteMapping(value = "/api/deleteTechnic", consumes = "application/json")
    public void deleteTechnic(@RequestParam int technicId);

    @PutMapping(value = "/api/updateTechnic", consumes = "application/json")
    public ResponseEntity<Technic> updateTechnic(@RequestParam int technicId, Technic technic);

    @GetMapping(value = "/api/getAllTechnics", consumes = "application/json")
    public ResponseEntity<List<Technic>> getAllTechnics();

    @GetMapping(value = "/api/findTechnicById", consumes = "application/json")
    public ResponseEntity<Technic> findTechnicById(@RequestParam int technicId);

    @PostMapping(value = "/api/getAllTechnicsByRouteId", consumes = "application/json")
    public ResponseEntity<List<Technic>> getAllTechnicsByRouteId(@RequestParam int technicId);



}
