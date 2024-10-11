package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.*;
import com.CoralieP98.Climb.Repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
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

    public List<Route> findAllRouteBySession(Session session) {
        return routeRepository.findAllRoutesBySession(session).get();
    }

    public List<Route> findAllRouteByType(Type type) {
        return routeRepository.findAllRoutesByType(type).get();
    }

    public List<Route> findAllRouteByTechnics(Technic technics) {
        return routeRepository.findAllRouteByTechnics(technics).get();
    }

    public List<Route> findAllRouteByExercices(Exercice exercices) {
        return routeRepository.findAllRouteByExercices(exercices).get();
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
