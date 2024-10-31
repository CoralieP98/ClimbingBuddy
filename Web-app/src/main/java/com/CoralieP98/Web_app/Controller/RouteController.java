package com.CoralieP98.Web_app.Controller;

import com.CoralieP98.Web_app.Model.Grade;
import com.CoralieP98.Web_app.Model.Route;
import com.CoralieP98.Web_app.Model.User;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import com.CoralieP98.Web_app.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        User user = userDetailsService.actualUser();
        model.addAttribute("user", user);
        model.addAttribute("route", new Route());
        List<Grade> grades = climbFeignClient.getAllGrades().getBody();
        model.addAttribute("grades", grades);
        return new ModelAndView("addRoute");
    }

    @GetMapping("/allRouteBySession/{sessionId}")
    public ModelAndView allRouteBySession(Model model,@PathVariable int sessionId){
        model.addAttribute("user", userDetailsService.actualUser());
        model.addAttribute("session", climbFeignClient.findSessionById(sessionId).getBody());
        model.addAttribute("routes",climbFeignClient.findAllRouteBySession(sessionId).getBody());
        return new ModelAndView("session","sessionId",sessionId);

    }
}
