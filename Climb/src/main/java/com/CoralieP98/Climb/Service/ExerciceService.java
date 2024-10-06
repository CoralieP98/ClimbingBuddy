package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Exercice;
import com.CoralieP98.Climb.Repository.ExerciceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciceService {

    private final ExerciceRepository exerciceRepository;

    public ExerciceService(ExerciceRepository exerciceRepository) {
        this.exerciceRepository = exerciceRepository;
    }

    public void createExercice(Exercice exercice) {
        exerciceRepository.save(exercice);
    }

    public void deleteExercice(int exerciceId) {
        exerciceRepository.deleteById(exerciceId);
    }

    public Exercice updateExercice(int exerciceId, Exercice exercice) {
        exerciceRepository.save(exercice);
        return exercice;
    }

    public List<Exercice> getAllExercices() {
        return exerciceRepository.findAll();
    }

    public Exercice findExerciceById(int exerciceId) {
        return exerciceRepository.findExerciceByExerciceId(exerciceId).get();
    }

    public List<Exercice> getAllExercicesByRouteId(int routeId) {
        return exerciceRepository.findAllExercicesByRouteId(routeId).get();
    }
}