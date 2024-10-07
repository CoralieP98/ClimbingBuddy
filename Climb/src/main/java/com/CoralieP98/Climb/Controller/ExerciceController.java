package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.Exercice;
import com.CoralieP98.Climb.Model.Route;
import com.CoralieP98.Climb.Service.ExerciceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ExerciceController {

    private final ExerciceService exerciceService;

    public ExerciceController(ExerciceService exerciceService) {
        this.exerciceService = exerciceService;
    }

    @PostMapping("createExercice")
    public Exercice createExercice(@RequestBody Exercice exercice){
        exerciceService.createExercice(exercice);
        return exercice;
    }

    @DeleteMapping("deleteExercice")
    public void deleteExercice(@RequestParam int exerciceId){
        exerciceService.deleteExercice(exerciceId);
    }

    @PutMapping("updateExercice")
    public Exercice updateExercice(@RequestParam(name = "exerciceId")int exerciceId, @RequestBody Exercice exercice){
        return exerciceService.updateExercice(exerciceId,exercice);
    }

    @GetMapping("getAllExercices")
    public List<Exercice> getAllExercices(){
        return exerciceService.getAllExercices();
    }

    @GetMapping("findExerciceById")
    public Exercice findExerciceById(@RequestParam int exerciceId){
        return exerciceService.findExerciceById(exerciceId);
    }


    @PostMapping("getAllExercicesByRoutes")
    public List<Exercice> getAllExercicesByRoutes(@RequestParam Route routes){
        return exerciceService.getAllExercicesByRoutes(routes);
    }
}
