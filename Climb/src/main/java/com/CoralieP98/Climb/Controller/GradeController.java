package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.Grade;
import com.CoralieP98.Climb.Service.GradeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("getGradeById")
    public Grade getGradeById(@RequestParam int gradeId) {
        return gradeService.getGradeById(gradeId);
    }
    @GetMapping("getAllGrades")
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }
}
