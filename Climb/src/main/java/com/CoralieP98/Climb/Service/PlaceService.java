package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Repository.PlaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public void createPlace(Place place){
        placeRepository.save(place);
    }

    public Place findPlaceById(int placeId) {
        return placeRepository.findPlaceByPlaceId(placeId).get();
    }


    public void deletePlace(int placeId) {
        placeRepository.deleteById(placeId);
    }

    public Place updatePlace(int placeId, Place place) {
        placeRepository.save(place);
        return place;
    }

    public List<Place> findFavoitePlacesById(int id) {
        return placeRepository.findAllPlacesByUserId(id).get();
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }
}
