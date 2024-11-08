package com.CoralieP98.sheets.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "exercicecard")
public class ExerciceCard {
    @Id
    private String exerciceCardId;
    private String exerciceName;
    private String exerciceDescription;
    private String difficulty;
    private String musclesTargeted;
    private String equipmentRequired;
}
