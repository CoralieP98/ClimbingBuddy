package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Route;
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
        routeRepository.save(route);
        return route;
    }

    public Route findRouteById(int routeId) {
        return routeRepository.findRouteByRouteId(routeId).get();
    }

    public List<Route> findAllRouteBySessionId(int sessionId) {
        return routeRepository.findAllRouteBySessionId(sessionId).get();
    }

    public List<Route> findAllRouteByTypeId(int typeId) {
        return routeRepository.findAllRouteByTypeId(typeId).get();
    }

    public List<Route> findAllRouteByTechnicId(int technicId) {
        return routeRepository.findAllRouteByTechnicId(technicId).get();
    }

    public List<Route> findAllRouteByExerciceId(int exerciceId) {
        return routeRepository.findAllRouteByExerciceId(exerciceId).get();
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
