package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Technic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicRepository extends JpaRepository<Technic, Integer> {

}
