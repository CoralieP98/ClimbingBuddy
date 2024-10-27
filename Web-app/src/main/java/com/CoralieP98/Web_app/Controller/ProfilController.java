package com.CoralieP98.Web_app.Controller;

import com.CoralieP98.Web_app.Model.Profil;
import com.CoralieP98.Web_app.Model.User;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import com.CoralieP98.Web_app.Service.CustomUserDetailsService;
import com.CoralieP98.Web_app.Service.ProfilService;
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

    private final ProfilService profilService;

    @GetMapping("profil")
    public ModelAndView profil(Model model){
        model.addAttribute("user",userDetailsService.actualUser());
        model.addAttribute("profil",profilService.actualProfil());
        return new ModelAndView("profil");
    }

    @PostMapping("/setProfil")
    public String saveProfil(@ModelAttribute("profil") Profil profil, Model model){
        User user = userDetailsService.actualUser();
        profil.setUser(user);
        climbFeignClient.createProfil(profil);
        model.addAttribute("profil",profilService.actualProfil());
        return "redirect:/profil";
    }

    @GetMapping("/setProfil")
    public ModelAndView setProfilForm(Model model){
        model.addAttribute("user",userDetailsService.actualUser());
        model.addAttribute("profil",new Profil());
        return new ModelAndView("setProfil");
    }

    @GetMapping("/updateProfil")
    public ModelAndView updateProfilForm(Model model ){
        Profil updateProfil = profilService.actualProfil();
        model.addAttribute("user",userDetailsService.actualUser());
        model.addAttribute("profil",updateProfil);
        return new ModelAndView("updateProfil");

    }

    @PostMapping("/updateProfil")
    public String updateProfil(@RequestParam(name = "profilId") int profilId,@ModelAttribute("profil") Profil profil){
        User user = userDetailsService.actualUser();
        profil.setUser(user);
        climbFeignClient.updateProfil(profilId,profil);
        return "redirect:/profil";
    }


}
