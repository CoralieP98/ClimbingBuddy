package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Route;
import com.CoralieP98.Climb.Model.Technic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechnicRepository extends JpaRepository<Technic, Integer> {

    public Optional<Technic> findTechnicByTechnicId(int technicId);

    public Optional<List<Technic>> findAllTechnicsByRoutes(Route routes);

}
