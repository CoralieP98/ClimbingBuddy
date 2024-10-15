package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Model.Session;
import com.CoralieP98.Climb.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    public Optional<Session> findSessionBySessionId(int sessionId);

    public Optional<List<Session>> findAllSessionByUserId(int id);

    public Optional<List<Session>> findAllSessionsByPlaceAndUser(Place place,User user);


    public Optional<Session> findSessionByDate(LocalDate date);


}
