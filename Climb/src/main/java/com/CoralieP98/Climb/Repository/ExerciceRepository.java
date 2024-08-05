package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Integer> {
}
