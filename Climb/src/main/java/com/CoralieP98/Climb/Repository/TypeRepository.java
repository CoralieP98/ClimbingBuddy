package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    public Optional<Type> findTypeByTypeId(int typeId);
}
