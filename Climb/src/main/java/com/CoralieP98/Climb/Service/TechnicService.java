package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Route;
import com.CoralieP98.Climb.Model.Technic;
import com.CoralieP98.Climb.Repository.TechnicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicService {

    private final TechnicRepository technicRepository;

    public TechnicService(TechnicRepository technicRepository) {
        this.technicRepository = technicRepository;
    }

    public void createTechnic(Technic technic) {
        technicRepository.save(technic);
    }

    public void deleteTechnic(int technicId) {
        technicRepository.deleteById(technicId);
    }

    public Technic updateTechnic(int technicId, Technic technic) {
        technicRepository.save(technic);
        return technic;
    }

    public List<Technic> getAllTechnics() {
        return technicRepository.findAll();
    }

    public Technic findTechnicById(int technicId) {
        return technicRepository.findTechnicByTechnicId(technicId).get();
    }

    public List<Technic> getAllTechnicsByRoutes(Route route) {
        return technicRepository.findAllTechnicsByRoutes(route).get();
    }
}
