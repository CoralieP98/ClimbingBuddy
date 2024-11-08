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
@Document(collection = "techniquecard")
public class TechniqueCard {
    @Id
    private String techniqueCardID;
    private String techniqueName;
    private String techniqueDescription;
    private String techniqueTips;

}
