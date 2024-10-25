package com.CoralieP98.Web_app.Controller;

import com.CoralieP98.Web_app.Model.Profil;
import com.CoralieP98.Web_app.Model.User;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import com.CoralieP98.Web_app.Service.CustomUserDetailsService;
import com.CoralieP98.Web_app.Service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ProfilController {

    private final ClimbFeignClient climbFeignClient;

    private final UserServiceImpl userService;

    private final CustomUserDetailsService userDetailsService;

    @GetMapping("/profil")
    public ModelAndView userProfil(Model model){
        model.addAttribute("user",userDetailsService.actualUser());
        return new ModelAndView("profil");
    }

    @PostMapping("/setProfil")
    public String saveProfil(@ModelAttribute("user") User user,@ModelAttribute("profil") Profil profil){
        climbFeignClient.createProfil(profil);
        return "redirect:/profil";
    }

    @GetMapping("/setProfil")
    public ModelAndView setProfilForm(Model model){
        model.addAttribute("user",userDetailsService.actualUser());
        model.addAttribute("profil",userDetailsService.actualUser());
        return new ModelAndView("setProfil");
    }

    @GetMapping("/updateProfil")
    public ModelAndView updateProfilForm(@RequestParam(name = "profilId") int profilId,Model model ){
        Profil updateProfil = climbFeignClient.getProfilById(profilId).getBody();
        model.addAttribute("user",userDetailsService.actualUser());
        model.addAttribute("profil",userDetailsService.actualUser());

    }

    @PutMapping("/updateProfil")
    public String updateProfil(@RequestParam(name = "profilId") int profilId,Profil profil){
        climbFeignClient.updateProfil(profilId,profil);
        return "redirect:/profil";

    }


}
