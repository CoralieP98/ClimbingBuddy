package com.CoralieP98.Web_app.Controller;

import com.CoralieP98.Web_app.Model.Place;
import com.CoralieP98.Web_app.Model.User;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import com.CoralieP98.Web_app.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


@Controller
@RequiredArgsConstructor
public class PlaceController {

    private final CustomUserDetailsService userDetailsService;
    private final ClimbFeignClient climbFeignClient;

    @GetMapping("/addNewFavPlace")
    public ModelAndView addNewFavPlace(Model model) {

        User user = userDetailsService.actualUser();
        model.addAttribute("user", user);
        model.addAttribute("place", new Place());
        return new ModelAndView("addFavPlace");

    }

    @PostMapping("/addNewFavPlace")
    public String addNewFavPlace(@ModelAttribute Place place) {
        User user = userDetailsService.actualUser();

        place.setUser(user);
        climbFeignClient.createPlace(place);
        return "redirect:/addSession";


    }
}
