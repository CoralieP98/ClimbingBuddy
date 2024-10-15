package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.Place;
import com.CoralieP98.Climb.Service.PlaceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("createPlace")
    public Place createPlace(@RequestBody Place place){
        placeService.createPlace(place);
        return place;
    }

    @GetMapping("findPlaceById")
    public Place findPlaceById(@RequestParam int placeId){
        return placeService.findPlaceById(placeId);
    }

    @DeleteMapping("deletePlace")
    public void deletePlace(@RequestParam int placeId){
        placeService.deletePlace(placeId);
    }

    @PutMapping("updatePlace")
    public Place updatePlace(@RequestParam(name = "placeId")int placeId, @RequestBody Place place){
        return placeService.updatePlace(placeId, place);
    }

    @PostMapping("findFavoritePlacesByUserId")
    public List<Place> findFavoritePlaceById(@RequestParam int id){
        return placeService.findFavoitePlacesById(id);
    }

    @GetMapping("getAllPlaces")
    public List<Place> getAllPlaces(){
        return placeService.getAllPlaces();
    }
}
