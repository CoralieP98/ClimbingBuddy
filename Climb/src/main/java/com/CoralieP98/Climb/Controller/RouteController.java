package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.*;
import com.CoralieP98.Climb.Service.RouteService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("createRoute")
    public Route createRoute(@RequestBody Route route){
        routeService.createRoute(route);
        return route;
    }

    @DeleteMapping("deleteRoute")
    public void deleteRoute(@RequestParam int routeId){
        routeService.deleteRoute(routeId);
    }

    @PutMapping("updateRoute")
    public Route updateRoute(@RequestParam(name = "routeId")int routeId,@RequestBody Route route){
        return routeService.updateRoute(routeId,route);
    }

    @GetMapping("findRouteById")
    public Route findRouteByid(@RequestParam int routeId){
        return routeService.findRouteById(routeId);
    }


    @PostMapping("findAllRouteBySessionId")
    public List<Route> findAllRouteBySession(@RequestParam int sessionId){
        return routeService.findAllRouteBySession(sessionId);
    }

    @PostMapping("findAllRouteByTypeId")
    public List<Route> findAllRouteByType(@RequestParam int typeId){
        return routeService.findAllRouteByType(typeId);
    }

    @PostMapping("findAllRouteByGradeIdAndUserId")
    public List<Route> findAllRouteByGradeIdAndUserId(@RequestParam int gradeId, @RequestParam int id){
        return routeService.findAllRouteByGradeAndUser(gradeId, id);
    }

    @PostMapping("findAllRouteByTechniqueAndUserId")
    public List<Route> findAllRouteByTechnique(@RequestParam int techniqueId,@RequestParam int id){
        return routeService.findAllRouteByTechniqueAndUser(techniqueId,id);
    }

    @PostMapping("findAllRouteByExerciceAndUserId")
    public List<Route> findAllRouteByExercice(@RequestParam int exerciceId,@RequestParam int id){
        return routeService.findAllRouteByExerciceAndUser(exerciceId,id);
    }

    @GetMapping("getAllRoutes")
    public List<Route> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @PostMapping("getAllRoutesByUser")
    public List<Route> getAllRoutesByUser(@RequestParam int id){
        return routeService.getAllRoutesByUser(id);
    }

    @DeleteMapping("deleteAllRouteBySessionId")
    public void deleteAllRouteBySessionId(@RequestParam int sessionId){
        routeService.deleteAllRouteBySessionId(sessionId);
    }





}
