package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.Profil;
import com.CoralieP98.Climb.Model.Session;
import com.CoralieP98.Climb.Service.ProfilService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProfilController {

    private final ProfilService profilService;

    public ProfilController(ProfilService profilService) {
        this.profilService = profilService;
    }

    @PostMapping("createProfil")
    public Profil createProfil(@RequestBody Profil profil) {
        profilService.createProfil(profil);
        return profil;
    }

    @PutMapping("updateProfil")
    public Profil updateProfil(@RequestParam(name = "profilId") int profilId, @RequestBody Profil profil) {
        return profilService.updateProfil(profilId,profil);
    }

    @GetMapping("getProfilById")
    public Profil getProfilById(@RequestParam(name = "profilId") int profilId) {
        return profilService.getProfilById(profilId);
    }

    @DeleteMapping("deleteProfil")
    public void deleteProfil(@RequestParam(name = "profilId") int profilId) {
        profilService.deleteProfilById(profilId);
    }

    @PostMapping("getProfilByUserId")
    public Profil getProfilByUserId(@RequestParam int id) {
        return profilService.getProfilByUserId(id);
    }
}
