package com.CoralieP98.Climb.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Technique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int techniqueId;

    private String labelTechnique;

    private Long cardId; //card etant une table mongo voir comment faire le lien


    public int getTechniqueId() {
        return techniqueId;
    }

    public void setTechniqueId(int techniqueId) {
        this.techniqueId = techniqueId;
    }

    public String getLabelTechnique() {
        return labelTechnique;
    }

    public void setLabelTechnique(String labelTechnique) {
        this.labelTechnique = labelTechnique;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
}
