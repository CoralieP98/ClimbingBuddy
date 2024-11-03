package com.CoralieP98.Web_app.Controller;

import com.CoralieP98.Web_app.Model.Place;
import com.CoralieP98.Web_app.Model.Session;
import com.CoralieP98.Web_app.Model.User;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import com.CoralieP98.Web_app.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SessionController {

    private final CustomUserDetailsService userDetailsService;
    private final ClimbFeignClient climbFeignClient;


    @GetMapping("/addSession")
    public ModelAndView addSession(Model model){
        User user = userDetailsService.actualUser();
        model.addAttribute("user",user);
        model.addAttribute("createdSession", new Session());
        List<Place> places = climbFeignClient.findFavoritePlaceById(user.getId()).getBody();
        model.addAttribute("places", places);
        return new ModelAndView("addSession");
    }

    @PostMapping("/addSession")
    public String addSession(@ModelAttribute("session") Session session, Model model){
        User user = userDetailsService.actualUser();
        List<Place> places = climbFeignClient.findFavoritePlaceById(user.getId()).getBody();
        model.addAttribute("places", places);
        session.setUser(user);
        Session createdSession = climbFeignClient.createSession(session).getBody();
        model.addAttribute("createdSession", createdSession);
        return "redirect:/allRouteBySession/" + createdSession.getSessionId();
    }

    @GetMapping("/updateSession/{sessionId}")
    public ModelAndView updateSession(@PathVariable("sessionId") int sessionId, Model model){
        Session actualSession = climbFeignClient.findSessionById(sessionId).getBody();
        User user = userDetailsService.actualUser();
        model.addAttribute("user",user);
        model.addAttribute("actualSession", actualSession);
        List<Place> places = climbFeignClient.findFavoritePlaceById(user.getId()).getBody();
        model.addAttribute("places", places);
        return new ModelAndView("updateSession");
    }

    @PostMapping("/updateSession/{sessionId}")
    public String updateSession(@PathVariable("sessionId") int sessionId, @ModelAttribute("session") Session session,Model model){
        User user = userDetailsService.actualUser();
        List<Place> places = climbFeignClient.findFavoritePlaceById(user.getId()).getBody();
        model.addAttribute("places", places);
        session.setUser(user);
        climbFeignClient.updateSession(sessionId,session).getBody();
        return "redirect:/allRouteBySession/{sessionId}";
    }

    @GetMapping("/listSession")
    public ModelAndView listSession(Model model){
        model.addAttribute("user",userDetailsService.actualUser());
        model.addAttribute("sessions", climbFeignClient.findAllSessionByUserId(userDetailsService.actualUser().getId()).getBody());
        return new ModelAndView("listSession");
    }

    @GetMapping("/deleteSession/{sessionId}")
    public String deleteSession(@PathVariable("sessionId") int sessionId){
        climbFeignClient.deleteSession(sessionId);
        return "redirect:/listSession";
    }



}
