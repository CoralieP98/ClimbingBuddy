package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.Technic;
import com.CoralieP98.Climb.Service.TechnicService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TechnicController {

    private final TechnicService technicService;

    public TechnicController(TechnicService technicService) {
        this.technicService = technicService;
    }

    @PostMapping("createTechnic")
    public Technic createTechnic(@RequestBody Technic technic){
        technicService.createTechnic(technic);
        return technic;
    }

    @DeleteMapping("deleteTechnic")
    public void deleteTechnic(@RequestParam int technicId){
        technicService.deleteTechnic(technicId);
    }

    @PutMapping("updateTechnic")
    public Technic updateTechnic(@RequestParam(name = "technicId") int technicId,@RequestBody Technic technic){
        return technicService.updateTechnic(technicId, technic);
    }

    @GetMapping("getAllTechnics")
    public List<Technic> getAllTechnics(){
        return  technicService.getAllTechnics();
    }

    @GetMapping("findTechnicById")
    public Technic findTechnicById(@RequestParam int technicId){
        return technicService.findTechnicById(technicId);
    }

    @PostMapping("getAllTechnicsByRouteId")
    public List<Technic> getAllTechnicsByRouteId(@RequestParam int routeId){
        return technicService.getAllTechnicsByRouteId(routeId);
    }


}
