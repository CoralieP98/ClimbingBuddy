package com.CoralieP98.Web_app.Service.Client;

import com.CoralieP98.Web_app.Model.ExerciceCard;
import com.CoralieP98.Web_app.Model.TechniqueCard;
import com.CoralieP98.Web_app.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("sheets")
public interface SheetsFeignClient {

    @PostMapping(value = "/createCardExercice", consumes = "application/json")
    public ResponseEntity<ExerciceCard> createCardExercice(ExerciceCard exerciceCard);

    @GetMapping(value = "/getAllCardsExercices", consumes = "application/json")
    public ResponseEntity<List<ExerciceCard>> getAllExercices();

    @GetMapping(value = "/getCardExerciceById", consumes = "application/json")
    public ResponseEntity<ExerciceCard> getCardExerciceById(@RequestParam String exerciceCardId);

    /////////////////////////////////TECH/////////////////////////////////////

    @PostMapping(value = "/createCardTechnique", consumes = "application/json")
    public ResponseEntity<TechniqueCard> createCardTechnique(TechniqueCard techniqueCard);

    @GetMapping(value = "/getAllCardsTechniques", consumes = "application/json")
    public ResponseEntity<List<TechniqueCard>> getAllCardsTechniques();

    @GetMapping(value = "/getCardTechniqueById", consumes = "application/json")
    public ResponseEntity<TechniqueCard> getCardTechniqueById(@RequestParam String techniqueCardId);






}
