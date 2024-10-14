package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Technique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechniqueRepository extends JpaRepository<Technique, Integer> {

    public Optional<Technique> findTechniqueByTechniqueId(int techniqueId);

//    public Optional<List<Technique>> findAllTechnicsByRoutes(Route routes);

}
