package com.CoralieP98.Web_app.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
public class Profil {


    private int profilId;
    private int howManyYears;
    private int age;
    private String gender;
    private String ratherType;
    private String favoriteHolds;
    private String favoriteClimbingStyle;
    private String favoritePersonalities;
    private String aboutYou;


    private User user;


}
