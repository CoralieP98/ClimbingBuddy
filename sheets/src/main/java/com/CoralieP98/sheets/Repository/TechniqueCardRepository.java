package com.CoralieP98.sheets.Repository;

import com.CoralieP98.sheets.Model.TechniqueCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechniqueCardRepository extends MongoRepository<TechniqueCard, String> {
}
