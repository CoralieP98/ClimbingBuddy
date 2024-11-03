package com.CoralieP98.Web_app.Controller;

import com.CoralieP98.Web_app.Model.*;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import com.CoralieP98.Web_app.Service.CustomUserDetailsService;
import com.CoralieP98.Web_app.Service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class RouteController {

    private final CustomUserDetailsService userDetailsService;
    private final ClimbFeignClient climbFeignClient;

    @GetMapping("/addRoute/{sessionId}")
    public ModelAndView addRoute(Model model,@PathVariable int sessionId){
        model.addAttribute("route", new Route());
        List<Grade> grades = climbFeignClient.getAllGrades().getBody();
        List<Type> types = climbFeignClient.getAll3Types().getBody();
        List<Technique> techniques = climbFeignClient.getAllTechniques().getBody();
        List<Exercice> exercices = climbFeignClient.getAllExercices().getBody();
        Session actualSession = climbFeignClient.findSessionById(sessionId).getBody();

        model.addAttribute("grades", grades);
        model.addAttribute("types", types);
        model.addAttribute("techniques", techniques);
        model.addAttribute("exercices", exercices);
        model.addAttribute("actualSession", actualSession);

        return new ModelAndView("addRoute");
    }
//                .map(technique -> techniqueRepository.findById(technique.getTechniqueId()).orElseThrow())

    @PostMapping("/addRoute/{sessionId}")
    public String addRoute(@PathVariable("sessionId") int sessionId,@ModelAttribute("route") Route route,Model model){
        User user = userDetailsService.actualUser();
        Session actualSession = climbFeignClient.findSessionById(sessionId).getBody();
        route.setSession(actualSession);
        route.setUser(user);

        List<Technique> techniques = route.getTechniques().stream()
                .map(technique -> climbFeignClient.findTechniqueById(technique.getTechniqueId()).getBody())
                .collect(Collectors.toList());

        List<Exercice> exercices = route.getExercices().stream()
                .map(exercice -> climbFeignClient.findExerciceById(exercice.getExerciceId()).getBody())
                .collect(Collectors.toList());

        route.setTechniques(techniques);
        route.setExercices(exercices);

        Route createdRoute = climbFeignClient.createRoute(route).getBody();

        return "redirect:/allRouteBySession/" + createdRoute.getSession().getSessionId();
    }

    @GetMapping("/getRoute/{routeId}/{sessionId}")
    public ModelAndView getRoute(Model model,@PathVariable int routeId,@PathVariable int sessionId){

        Session actualSession = climbFeignClient.findSessionById(sessionId).getBody();
        Route actualRoute = climbFeignClient.findRouteByid(routeId).getBody();

        model.addAttribute("actualRoute", actualRoute);
        model.addAttribute("actualSession", actualSession);
        model.addAttribute("user", userDetailsService.actualUser());

//        assert actualRoute != null;
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
}
