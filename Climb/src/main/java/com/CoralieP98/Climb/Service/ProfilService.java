package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Profil;
import com.CoralieP98.Climb.Repository.ProfilRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfilService {

    private final ProfilRepository profilRepository;

    private final UserService userService;

    public ProfilService(ProfilRepository profilRepository, UserService userService) {
        this.profilRepository = profilRepository;
        this.userService = userService;
    }

    public void createProfil(Profil profil) {
        profil.setUser(userService.findUserById(profil.getUser().getId()));
        profilRepository.save(profil);
    }

    public Profil updateProfil(int profilId, Profil profil) {
        profil.setUser(userService.findUserById(profil.getUser().getId()));
        profil.setProfilId(profilId);
        return profilRepository.save(profil);
    }

    public Profil getProfilById(int profilId) {
        return profilRepository.findProfilByProfilId(profilId).get();
    }

    public void deleteProfilById(int profilId) {
        profilRepository.deleteById(profilId);
    }

    public Profil getProfilByUserId(int id) {
        return profilRepository.findProfilByUserId(id).get();
    }
}
