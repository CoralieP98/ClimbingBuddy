package com.CoralieP98.Web_app.Controller;

import com.CoralieP98.Web_app.Model.*;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import com.CoralieP98.Web_app.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RouteController {

    private final CustomUserDetailsService userDetailsService;
    private final ClimbFeignClient climbFeignClient;

    @GetMapping("/addRoute/{sessionId}")
    public ModelAndView addRoute(Model model,@PathVariable int sessionId){
        Route route = new Route();


        List<Grade> grades = climbFeignClient.getAllGrades().getBody();
        List<Type> types = climbFeignClient.getAll3Types().getBody();
        List<Technique> techniques = climbFeignClient.getAllTechniques().getBody();
        List<Exercice> exercices = climbFeignClient.getAllExercices().getBody();
        Session actualSession = climbFeignClient.findSessionById(sessionId).getBody();



        model.addAttribute("grades", grades);
        model.addAttribute("types", types);
        model.addAttribute("techniques", techniques);
        model.addAttribute("exercices", exercices);
        model.addAttribute("route", route);
        model.addAttribute("actualSession", actualSession);

        return new ModelAndView("addRoute");
    }


    @PostMapping("/addRoute/{sessionId}")
    public String addRoute(@PathVariable("sessionId") int sessionId,@ModelAttribute("route") Route route,Model model,@RequestParam(name = "techniqueIds", required = false) List<Integer> techniqueIds,@RequestParam(name = "exerciceIds", required = false) List<Integer> exerciceIds){
        User user = userDetailsService.actualUser();
        Session actualSession = climbFeignClient.findSessionById(sessionId).getBody();
        route.setSession(actualSession);
        route.setUser(user);

        if (techniqueIds != null) {
            List<Technique> selectedTechniques = climbFeignClient.findAllTechniquesById(techniqueIds).getBody();
            route.setTechniques(selectedTechniques);
        }else {
            route.setTechniques(new ArrayList<>());
        }

        if (exerciceIds != null) {
            List<Exercice> selectedExercices = climbFeignClient.findAllExercicesById(exerciceIds).getBody();
            route.setExercices(selectedExercices);
        }else {
            route.setExercices(new ArrayList<>());
        }

        Route createdRoute = climbFeignClient.createRoute(route).getBody();

        return "redirect:/allRouteBySession/" + createdRoute.getSession().getSessionId();


    }

    @GetMapping("/{sessionId}/{routeId}/updateRoute")
    public ModelAndView updateRoute(Model model,@PathVariable int sessionId,@PathVariable int routeId){
        User user = userDetailsService.actualUser();
        Session actualSession = climbFeignClient.findSessionById(sessionId).getBody();
        Route existingRoute = climbFeignClient.findRouteByid(routeId).getBody();
        model.addAttribute("user",user);
        model.addAttribute("actualSession", actualSession);

        List<Grade> grades = climbFeignClient.getAllGrades().getBody();
        List<Type> types = climbFeignClient.getAll3Types().getBody();
        List<Technique> techniques = climbFeignClient.getAllTechniques().getBody();
        List<Exercice> exercices = climbFeignClient.getAllExercices().getBody();

        model.addAttribute("grades", grades);
        model.addAttribute("types", types);
        model.addAttribute("techniques", techniques);
        model.addAttribute("exercices", exercices);
        model.addAttribute("route", existingRoute);

        return new ModelAndView("updateRoute");
    }

    @PostMapping("/{sessionId}/{routeId}/updateRoute")
    public String updateRoute( @PathVariable("sessionId") int sessionId,
                               @PathVariable("routeId") int routeId,
                               @ModelAttribute("route") Route route,
                               @RequestParam(name = "techniqueIds", required = false) List<Integer> techniqueIds,
                               @RequestParam(name = "exerciceIds", required = false) List<Integer> exerciceIds){

        Route existingRoute = climbFeignClient.findRouteByid(routeId).getBody();

        existingRoute.setGrade(route.getGrade());
        existingRoute.setType(route.getType());
        existingRoute.setSlab(route.isSlab());
        existingRoute.setOverHang(route.isOverHang());
        existingRoute.setLead(route.isLead());
        existingRoute.setTopRope(route.isTopRope());
        existingRoute.setARepeat(route.isARepeat());
        existingRoute.setFlash(route.isFlash());
        existingRoute.setLenght(route.getLenght());

        if (techniqueIds != null) {
            List<Technique> selectedTechniques = climbFeignClient.findAllTechniquesById(techniqueIds).getBody();
            existingRoute.setTechniques(selectedTechniques);
        } else {
            existingRoute.setTechniques(new ArrayList<>());
        }

        if (exerciceIds != null) {
            List<Exercice> selectedExercices = climbFeignClient.findAllExercicesById(exerciceIds).getBody();
            existingRoute.setExercices(selectedExercices);
        } else {
            existingRoute.setExercices(new ArrayList<>());
        }

        climbFeignClient.updateRoute(routeId, existingRoute);

        return "redirect:/allRouteBySession/" + existingRoute.getSession().getSessionId();

    }

    @GetMapping("/getRoute/{routeId}/{sessionId}")
    public ModelAndView getRoute(Model model,@PathVariable int routeId,@PathVariable int sessionId){

        Session actualSession = climbFeignClient.findSessionById(sessionId).getBody();
        Route actualRoute = climbFeignClient.findRouteByid(routeId).getBody();

        model.addAttribute("actualRoute", actualRoute);
        model.addAttribute("actualSession", actualSession);
        model.addAttribute("user", userDetailsService.actualUser());

        model.addAttribute("techniques", actualRoute.getTechniques());
        model.addAttribute("exercices", actualRoute.getExercices());


        return new ModelAndView("route");
    }


    @GetMapping("/allRouteBySession/{sessionId}")
    public ModelAndView allRouteBySession(Model model,@PathVariable int sessionId){
        model.addAttribute("user", userDetailsService.actualUser());
        Session actualSession = climbFeignClient.findSessionById(sessionId).getBody();
        model.addAttribute("actualSession", actualSession);
        model.addAttribute("routes",climbFeignClient.findAllRouteBySession(sessionId).getBody());
        return new ModelAndView("session");
    }

    @GetMapping("/{routeId}/{sessionId}/deleteRoute")
    public String deleteRoute(@PathVariable int routeId,@PathVariable int sessionId){
        climbFeignClient.deleteRoute(routeId);
        return "redirect:/allRouteBySession/{sessionId}";
    }
}
