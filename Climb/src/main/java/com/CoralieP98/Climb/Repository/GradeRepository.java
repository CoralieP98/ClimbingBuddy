package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Grade;
import com.CoralieP98.Climb.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    public Optional<Grade> findGradeByGradeId(int gradeId);

}
