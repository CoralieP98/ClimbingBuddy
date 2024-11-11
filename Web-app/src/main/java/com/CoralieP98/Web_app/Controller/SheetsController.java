package com.CoralieP98.Web_app.Controller;

import com.CoralieP98.Web_app.Model.ExerciceCard;
import com.CoralieP98.Web_app.Model.TechniqueCard;
import com.CoralieP98.Web_app.Service.Client.SheetsFeignClient;
import com.CoralieP98.Web_app.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class SheetsController {

    private final SheetsFeignClient sheetsFeignClient;
    private final CustomUserDetailsService userDetailsService;

    @GetMapping("/getListSheets")
    public ModelAndView getListSheets(Model model) {
        List<TechniqueCard> techniqueCards = sheetsFeignClient.getAllCardsTechniques().getBody();
        List<ExerciceCard> exerciceCards = sheetsFeignClient.getAllExercices().getBody();
       model.addAttribute("techniqueCards", techniqueCards);
       model.addAttribute("exerciceCards", exerciceCards);
       return new ModelAndView("listSheets");
    }

    @GetMapping("/{techniqueCardId}/getTechniqueCard")
    public ModelAndView getTechniqueCard(Model model,@PathVariable String techniqueCardId) {
        TechniqueCard actualTechniqueCard = sheetsFeignClient.getCardTechniqueById(techniqueCardId).getBody();
        model.addAttribute("actualTechniqueCard", actualTechniqueCard);
        return new ModelAndView("techniqueCard");

    }

    @GetMapping("/{exerciceCardId}/getExerciceCard")
    public ModelAndView getExerciceCard(Model model,@PathVariable String exerciceCardId) {
        ExerciceCard actualExerciceCard = sheetsFeignClient.getCardExerciceById(exerciceCardId).getBody();
        model.addAttribute("actualExerciceCard", actualExerciceCard);
        return new ModelAndView("exerciceCard");
    }




}
