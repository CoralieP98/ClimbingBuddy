package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.Route;
import com.CoralieP98.Climb.Model.Technique;
import com.CoralieP98.Climb.Service.TechnicService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TechnicController {

    private final TechnicService techniqueService;

    public TechnicController(TechnicService techniqueService) {
        this.techniqueService = techniqueService;
    }

    @PostMapping("createTechnique")
    public Technique createTechnique(@RequestBody Technique technique){
        techniqueService.createTechnique(technique);
        return technique;
    }

    @DeleteMapping("deleteTechnique")
    public void deleteTechnique(@RequestParam int techniqueId){
        techniqueService.deleteTechnique(techniqueId);
    }

    @PutMapping("updateTechnique")
    public Technique updateTechnique(@RequestParam(name = "techniqueId") int techniqueId, @RequestBody Technique technique){
        return techniqueService.updateTechnique(techniqueId, technique);
    }

    @GetMapping("getAllTechniques")
    public List<Technique> getAllTechniques(){
        return  techniqueService.getAllTechniques();
    }

    @GetMapping("findTechniqueById")
    public Technique findTechniqueById(@RequestParam int techniqueId){
        return techniqueService.findTechniqueById(techniqueId);
    }

//    @PostMapping("getAllTechnicsByRoutes")
//    public List<Technique> getAllTechnicsByRoutes(@RequestParam Route routes){
//        return technicService.getAllTechnicsByRoutes(routes);
//    }


}
