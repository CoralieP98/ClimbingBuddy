package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Grade;
import com.CoralieP98.Climb.Repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Grade getGradeById(int gradeId) {
        return gradeRepository.findGradeByGradeId(gradeId).get();
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }
}
