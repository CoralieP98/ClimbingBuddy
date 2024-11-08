package com.CoralieP98.sheets.Controller;

import com.CoralieP98.sheets.Model.ExerciceCard;
import com.CoralieP98.sheets.Repository.ExerciceCardRepository;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciceCardController {

    private final ExerciceCardRepository exerciceCardRepository;

    public ExerciceCardController(ExerciceCardRepository exerciceCardRepository) {
        this.exerciceCardRepository = exerciceCardRepository;
    }

    @PostMapping("/createCardExercice")
    public ExerciceCard createCardExercice(@RequestBody ExerciceCard exerciceCard) {
        return exerciceCardRepository.save(exerciceCard);
    }

    @GetMapping("/getCardExerciceById")
    public ExerciceCard getCardExerciceById(@RequestParam String exerciceCardId) {
        return exerciceCardRepository.findById(exerciceCardId).get();
    }

    @GetMapping("/getAllCardsExercices")
    public List<ExerciceCard> getAllExercices() {
        return exerciceCardRepository.findAll();
    }
}
