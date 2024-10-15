package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Profil;
import com.CoralieP98.Climb.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Integer> {

    public Optional<Profil> findProfilByProfilId(int ProfilId);

    public Optional<Profil> findProfilByUserId(int id);
}
