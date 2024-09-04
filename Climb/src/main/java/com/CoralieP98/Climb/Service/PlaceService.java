package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Repository.PlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
}
