package com.CoralieP98.Web_app.Service;
import com.CoralieP98.Web_app.Model.Profil;
import com.CoralieP98.Web_app.Model.User;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ProfilService {

    private final CustomUserDetailsService customUserDetailsService;

    private final ClimbFeignClient climbFeignClient;

    public Profil actualProfil()  {
        User actualUser = customUserDetailsService.actualUser();
        Profil profil = climbFeignClient.getProfilByUserId(actualUser.getId()).getBody();
        return profil;
    }
}
