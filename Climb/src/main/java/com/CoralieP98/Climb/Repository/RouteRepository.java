package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Route;
import com.CoralieP98.Climb.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route,Integer> {

    public Optional<Route> findRouteByRouteId(int routeId);

    public Optional<List<Route>> findAllRouteBySessionId(int sessionId);

    public Optional<List<Route>> findAllRouteByTypeId(int typeId);

    public Optional<List<Route>> findAllRouteByTechnicId(int technicId);

    public Optional<List<Route>> findAllRouteByExerciceId(int exerciceId);

}
