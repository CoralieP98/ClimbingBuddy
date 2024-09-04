package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

    public Optional<Place> findSessionById(int placeId);


}
