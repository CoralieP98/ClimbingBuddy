package com.CoralieP98.Web_app.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technique {

    private int technicId;

    private String labelTechnic;

    private Long cardId; //card etant une table mongo voir comment faire le lien

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
