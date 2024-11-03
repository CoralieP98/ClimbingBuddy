package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Technique;
import com.CoralieP98.Climb.Repository.TechniqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechniqueService {


    private final TechniqueRepository techniqueRepository;

    public TechniqueService(TechniqueRepository techniqueRepository) {
        this.techniqueRepository = techniqueRepository;
    }

    public void createTechnique(Technique technique) {
        techniqueRepository.save(technique);
    }

    public void deleteTechnique(int techniqueId) {
        techniqueRepository.deleteById(techniqueId);
    }

    public Technique updateTechnique(int techniqueId, Technique technique) {
        technique.setTechniqueId(techniqueId);
        return techniqueRepository.save(technique);
    }

    public List<Technique> getAllTechniques() {
        return techniqueRepository.findAll();
    }

    public Technique findTechniqueById(int techniqueId) {
        return techniqueRepository.findTechniqueByTechniqueId(techniqueId).get();
    }


    public List<Technique> findAllTechniquesById(List<Integer> techniqueIds) {
        return techniqueRepository.findAllById(techniqueIds);

    }
}
