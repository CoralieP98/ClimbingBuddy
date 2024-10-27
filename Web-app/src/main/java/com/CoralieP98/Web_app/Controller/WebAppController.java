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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class WebAppController {

    private final ClimbFeignClient climbFeignClient;

    private final UserServiceImpl userService;

    private final CustomUserDetailsService userDetailsService;

    private final ProfilService profilService;


//    @GetMapping("/")
//    public String home(Model model){
//        return "redirect:/loadingPage";
//    }

    @GetMapping("/loadingPage")
    public ModelAndView loadingPage(){
        return new ModelAndView("loading");
    }

    @PostMapping("/signUp")
    public ModelAndView userSignUp(@ModelAttribute("user") User user){
        userService.register(user);
        return new ModelAndView("signIn");
    }

    @GetMapping("/signUp")
    public ModelAndView showUserForm(){
        return new ModelAndView("signUp", "user",new User());
    }


    @GetMapping("/homeNew")
    public ModelAndView homeNew(){return new ModelAndView("homePage_first");}

    @GetMapping("/home")
    public ModelAndView home(Model model){
        User actualUser = userDetailsService.actualUser();
        model.addAttribute("user", actualUser);
        Profil profil = climbFeignClient.getProfilByUserId(actualUser.getId()).getBody();
        if (profil == null) {
                return new ModelAndView("homePage_first");
            }
        return new ModelAndView("homePage");
    }

    @GetMapping("/profilHome")
    public String userProfilHome(String email) {
        userDetailsService.loadUserByUsername(email);
        return "redirect:/home";
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/user/list")
    public ModelAndView userList(Model model){
        model.addAttribute("users", climbFeignClient.getAllUsers().getBody());
        return new ModelAndView("users");
    }

    @GetMapping("/user/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") int id,Model model){
        User updateUser = climbFeignClient.findUserById(id).getBody();
        model.addAttribute("user", updateUser);
        return new ModelAndView("updateUser");
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") int id, User user){
        climbFeignClient.updateUser(id, user);
        return  "redirect:/profilHome"; //!!! penser a creer endroit ou mod ses infos d'user et ou revenir !!!
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        climbFeignClient.deleteUser(id);
        return "redirect:/signup"; //sorte de suppression de compte !! y faire attention !!
    }




}
