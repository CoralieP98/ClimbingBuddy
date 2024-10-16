package com.CoralieP98.Web_app.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Technique {

    private int technicId;

    private String labelTechnic;

    private Long cardId; //card etant une table mongo voir comment faire le lien


}
