package com.CoralieP98.Climb.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Technic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int technicId;

    private String labelTechnic;

    private Long cardId; //card etant une table mongo voir comment faire le lien

    public Technic() {
    }

    public Technic(int technicId, String labelTechnic, Long cardId) {
        this.technicId = technicId;
        this.labelTechnic = labelTechnic;
        this.cardId = cardId;
    }

    public int getTechnicId() {
        return technicId;
    }

    public void setTechnicId(int technicId) {
        this.technicId = technicId;
    }

    public String getLabelTechnic() {
        return labelTechnic;
    }

    public void setLabelTechnic(String labelTechnic) {
        this.labelTechnic = labelTechnic;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
}
