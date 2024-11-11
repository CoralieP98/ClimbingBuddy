package com.CoralieP98.stats.Model;


import lombok.Data;

@Data
public class Technique {

    private int techniqueId;


    private String labelTechnique;

    private Long cardId; //card etant une table mongo voir comment faire le lien


}
