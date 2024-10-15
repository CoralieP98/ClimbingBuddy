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

    private final UserService userService;

    public PlaceService(PlaceRepository placeRepository, UserService userService) {
        this.placeRepository = placeRepository;
        this.userService = userService;
    }

    public void createPlace(Place place){
        place.setUser(userService.findUserById(place.getUser().getId()));
        placeRepository.save(place);
    }

    public Place findPlaceById(int placeId) {
        return placeRepository.findPlaceByPlaceId(placeId).get();
    }


    public void deletePlace(int placeId) {
        placeRepository.deleteById(placeId);
    }

    public Place updatePlace(int placeId, Place place) {
        place.setUser(userService.findUserById(place.getUser().getId()));
        place.setPlaceId(placeId);
        return placeRepository.save(place);
    }

    public List<Place> findFavoitePlacesById(int id) {
        return placeRepository.findAllPlacesByUserId(id).get();
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }
}
