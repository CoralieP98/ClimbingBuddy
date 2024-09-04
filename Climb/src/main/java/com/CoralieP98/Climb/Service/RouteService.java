package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Repository.RouteRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
}
