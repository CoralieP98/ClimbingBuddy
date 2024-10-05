package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Integer> {

    public Optional<Exercice> findExerciceByExerciceId(int exerciceId);

    public Optional<List<Exercice>> findAllExercicesByRouteId(int routeId);
}
