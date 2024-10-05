package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.Type;
import com.CoralieP98.Climb.Repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type getTypeById(int typeId) {
        return typeRepository.findTypeByTypeId(typeId).get();
    }
}
