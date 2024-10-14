package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.*;
import com.CoralieP98.Climb.Repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    private final SessionService sessionService;

    public RouteService(RouteRepository routeRepository, SessionService sessionService) {
        this.routeRepository = routeRepository;
        this.sessionService = sessionService;
    }

    public void createRoute(Route route) {
        routeRepository.save(route);
    }

    public void deleteRoute(int routeId) {
        routeRepository.deleteById(routeId);
    }

    public Route updateRoute(int routeId, Route route) {
        route.setRouteId(routeId);
        return routeRepository.save(route);
    }

    public Route findRouteById(int routeId) {
        return routeRepository.findRouteByRouteId(routeId).get();
    }

    public List<Route> findAllRouteBySession(int sessionId) {
        Session session = sessionService.findSessionById(sessionId);
        return routeRepository.findAllRouteBySession(session).get();
    }

//    public List<Route> findAllRouteBySessionId(int sessionId) {
//        return routeRepository.findAllRouteBySessionId(sessionId).get();
//    }

//    public List<Route> findAllRouteByType(Type type) {
//        return routeRepository.findAllRoutesByType(type).get();
//    }

//    public List<Route> findAllRouteByTechnics(Technique technics) {
//        return routeRepository.findAllRouteByTechnics(technics).get();
//    }

//    public List<Route> findAllRouteByExercices(Exercice exercices) {
//        return routeRepository.findAllRouteByExercices(exercices).get();
//    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
