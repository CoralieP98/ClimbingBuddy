package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.*;
import com.CoralieP98.Climb.Repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    private final SessionService sessionService;

    private final TypeService typeService;

    private final TechniqueService techniqueService;

    private final ExerciceService exerciceService;

    private final GradeService gradeService;

    public RouteService(RouteRepository routeRepository, SessionService sessionService, TypeService typeService, TechniqueService techniqueService, ExerciceService exerciceService, GradeService gradeService) {
        this.routeRepository = routeRepository;
        this.sessionService = sessionService;
        this.typeService = typeService;
        this.techniqueService = techniqueService;
        this.exerciceService = exerciceService;
        this.gradeService = gradeService;
    }

    public void createRoute(Route route) {
        route.setSession(sessionService.findSessionById(route.getSession().getSessionId()));
        route.setType(typeService.getTypeById(route.getType().getTypeId()));
        routeRepository.save(route);
    }

    public void deleteRoute(int routeId) {
        routeRepository.deleteById(routeId);
    }

    public Route updateRoute(int routeId, Route route) {
        route.setSession(sessionService.findSessionById(route.getSession().getSessionId()));
        route.setType(typeService.getTypeById(route.getType().getTypeId()));
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

    public List<Route> findAllRouteByType(int typeId) {
        Type type = typeService.getTypeById(typeId);
        return routeRepository.findAllRoutesByType(type).get();
    }

    public List<Route> findAllRouteByTechnique(int techniqueId) {
        Technique techniques = techniqueService.findTechniqueById(techniqueId);
        return routeRepository.findAllRouteByTechniques(techniques).get();
    }

    public List<Route> findAllRouteByExercice(int exerciceId) {
        Exercice exercices = exerciceService.findExerciceById(exerciceId);
        return routeRepository.findAllRouteByExercices(exercices).get();
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<Route> findAllRouteByGrade(int gradeId) {
        Grade grade = gradeService.getGradeById(gradeId);
        return routeRepository.findAllRouteByGrade(grade).get();
    }
}
