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

    private final UserService userService;

    public RouteService(RouteRepository routeRepository, SessionService sessionService, TypeService typeService, TechniqueService techniqueService, ExerciceService exerciceService, GradeService gradeService, UserService userService) {
        this.routeRepository = routeRepository;
        this.sessionService = sessionService;
        this.typeService = typeService;
        this.techniqueService = techniqueService;
        this.exerciceService = exerciceService;
        this.gradeService = gradeService;
        this.userService = userService;
    }

    public void createRoute(Route route) {
        route.setUser(userService.findUserById(route.getUser().getId()));
        route.setSession(sessionService.findSessionById(route.getSession().getSessionId()));
        route.setType(typeService.getTypeById(route.getType().getTypeId()));
        route.setGrade(gradeService.getGradeById(route.getGrade().getGradeId()));
        List<Technique> techniqueList = route.getTechniques();
        for (Technique technique : techniqueList) {
            technique.setLabelTechnique(techniqueService.findTechniqueById(technique.getTechniqueId()).getLabelTechnique());
            technique.setCardId(techniqueService.findTechniqueById(technique.getTechniqueId()).getCardId());
        }
        List<Exercice> exerciceList = route.getExercices();
        for (Exercice exercice : exerciceList) {
            exercice.setLabelExercice(exerciceService.findExerciceById(exercice.getExerciceId()).getLabelExercice());
            exercice.setCardId(exerciceService.findExerciceById(exercice.getExerciceId()).getCardId());
        }
        routeRepository.save(route);
    }

    public void deleteRoute(int routeId) {
        routeRepository.deleteById(routeId);
    }

    public Route updateRoute(int routeId, Route route) {
        route.setUser(userService.findUserById(route.getUser().getId()));
        route.setSession(sessionService.findSessionById(route.getSession().getSessionId()));
        route.setType(typeService.getTypeById(route.getType().getTypeId()));
        route.setGrade(gradeService.getGradeById(route.getGrade().getGradeId()));
        List<Technique> techniqueList = route.getTechniques();
        for (Technique technique : techniqueList) {
            technique.setLabelTechnique(techniqueService.findTechniqueById(technique.getTechniqueId()).getLabelTechnique());
            technique.setCardId(techniqueService.findTechniqueById(technique.getTechniqueId()).getCardId());
        }
        List<Exercice> exerciceList = route.getExercices();
        for (Exercice exercice : exerciceList) {
            exercice.setLabelExercice(exerciceService.findExerciceById(exercice.getExerciceId()).getLabelExercice());
            exercice.setCardId(exerciceService.findExerciceById(exercice.getExerciceId()).getCardId());
        }
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

    public List<Route> findAllRouteByTechniqueAndUser(int techniqueId, int id) {
        User user = userService.findUserById(id);
        Technique techniques = techniqueService.findTechniqueById(techniqueId);
        return routeRepository.findAllRouteByTechniquesAndUser(techniques, user).get();
    }

    public List<Route> findAllRouteByExerciceAndUser(int exerciceId,  int id) {
        User user = userService.findUserById(id);
        Exercice exercices = exerciceService.findExerciceById(exerciceId);
        return routeRepository.findAllRouteByExercicesAndUser(exercices, user).get();
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<Route> findAllRouteByGradeAndUser(int gradeId, int id) {
        User user = userService.findUserById(id);
        Grade grade = gradeService.getGradeById(gradeId);
        return routeRepository.findAllRouteByGradeAndUser(grade,user).get();
    }

    public List<Route> getAllRoutesByUser(int id) {
        return routeRepository.findAllRoutesByUserId(id).get();
    }

    public void deleteAllRouteBySessionId(int sessionId) {
        Session session = sessionService.findSessionById(sessionId);
        routeRepository.deleteAllRouteBySessionSessionId(sessionId);
    }
}
