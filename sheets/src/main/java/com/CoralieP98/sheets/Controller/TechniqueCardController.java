package com.CoralieP98.sheets.Controller;

import com.CoralieP98.sheets.Model.TechniqueCard;
import com.CoralieP98.sheets.Repository.TechniqueCardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechniqueCardController {

    private final TechniqueCardRepository techniqueCardRepository;

    public TechniqueCardController(TechniqueCardRepository techniqueCardRepository) {
        this.techniqueCardRepository = techniqueCardRepository;
    }

    @PostMapping("/createCardTechnique")
    public TechniqueCard createCardTechnique(@RequestBody TechniqueCard techniqueCard) {
        return techniqueCardRepository.save(techniqueCard);
    }

    @GetMapping("/getCardTechniqueById")
    public TechniqueCard getCardTechniqueById(@RequestParam String techniqueCardId) {
        return techniqueCardRepository.findById(techniqueCardId).get();
    }

    @GetMapping("/getAllCardsTechniques")
    public List<TechniqueCard> getAllCardsTechniques() {
        return techniqueCardRepository.findAll();
    }
}
