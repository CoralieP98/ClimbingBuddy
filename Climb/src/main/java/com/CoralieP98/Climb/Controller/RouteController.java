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

    @PostMapping("findAllRouteBySession")
    public List<Route> findAllRouteBySession(@RequestParam Session session){
        return routeService.findAllRouteBySession(session);
    }

    @PostMapping("findAllRouteByType")
    public List<Route> findAllRouteByType(@RequestParam Type type){
        return routeService.findAllRouteByType(type);
    }

    @PostMapping("findAllRouteByTechnics")
    public List<Route> findAllRouteByTechnics(@RequestParam Technic technics){
        return routeService.findAllRouteByTechnics(technics);
    }

    @PostMapping("findAllRouteByExercices")
    public List<Route> findAllRouteByExercices(@RequestParam Exercice exercices){
        return routeService.findAllRouteByExercices(exercices);
    }

    @GetMapping("getAllRoutes")
    public List<Route> getAllRoutes(){
        return routeService.getAllRoutes();
    }

}
