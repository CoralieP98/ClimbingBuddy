package com.CoralieP98.sheets.Repository;

import com.CoralieP98.sheets.Model.ExerciceCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceCardRepository extends MongoRepository<ExerciceCard, String> {

}
