package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route,Integer> {

    public Optional<Route> findRouteByRouteId(int routeId);

    public Optional<List<Route>> findAllRoutesBySession(Session session);

    public Optional<List<Route>> findAllRoutesByType(Type type);

    public Optional<List<Route>> findAllRouteByTechnics(Technic technics);

    public Optional<List<Route>> findAllRouteByExercices(Exercice exercices);

}
