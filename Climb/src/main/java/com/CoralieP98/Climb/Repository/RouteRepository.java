package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route,Integer> {

    public Optional<Route> findRouteByRouteId(int routeId);

    public Optional<List<Route>> findAllRouteBySession(Session session);

    public Optional<List<Route>> findAllRoutesByType(Type type);

    public Optional<List<Route>> findAllRouteByTechniquesAndUser(Technique techniques,User user);

    public Optional<List<Route>> findAllRouteByExercicesAndUser(Exercice exercices, User user);

    public Optional<List<Route>> findAllRouteByGradeAndUser(Grade grade,User user);

    public Optional<List<Route>> findAllRoutesByUserId(int id);

}
