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

@Controller
@RequiredArgsConstructor
public class RouteController {

    private final CustomUserDetailsService userDetailsService;
    private final ClimbFeignClient climbFeignClient;

    @GetMapping("/addRoute")
    public ModelAndView addRoute(Model model){
        model.addAttribute("route", new Route());

        List<Grade> grades = climbFeignClient.getAllGrades().getBody();
        List<Type> types = climbFeignClient.getAll3Types().getBody();
        List<Technique> techniques = climbFeignClient.getAllTechniques().getBody();
        List<Exercice> exercices = climbFeignClient.getAllExercices().getBody();
//        User user = userDetailsService.actualUser();
//        Session session = climbFeignClient.findSessionById(sessionId).getBody();


        model.addAttribute("grades", grades);
        model.addAttribute("types", types);
        model.addAttribute("techniquelist", techniques);
        model.addAttribute("exercicelist", exercices);
//        model.addAttribute("user", user);
//        model.addAttribute("session", session);

        return new ModelAndView("addRoute");
    }


    @PostMapping("/addRoute")
    public String addRoute(@ModelAttribute("route") Route route,Model model){
        User user = userDetailsService.actualUser();
        route.setUser(user);
        climbFeignClient.createRoute(route);

        return "redirect:/allRouteBySession/" + route.getSession().getSessionId();


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
