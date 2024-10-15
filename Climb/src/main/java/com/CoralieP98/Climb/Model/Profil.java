package com.CoralieP98.Climb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profilId;
    private int howManyYears;
    private int age;
    private String gender;
    private String ratherType;
    private String favoriteHolds;
    private String favoriteClimbingStyle;
    private String favoritePersonalities;
    private String aboutYou;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;










    public int getProfilId() {
        return profilId;
    }

    public void setProfilId(int profilId) {
        this.profilId = profilId;
    }

    public int getHowManyYears() {
        return howManyYears;
    }

    public void setHowManyYears(int howManyYears) {
        this.howManyYears = howManyYears;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRatherType() {
        return ratherType;
    }

    public void setRatherType(String ratherType) {
        this.ratherType = ratherType;
    }

    public String getFavoriteHolds() {
        return favoriteHolds;
    }

    public void setFavoriteHolds(String favoriteHolds) {
        this.favoriteHolds = favoriteHolds;
    }

    public String getFavoriteClimbingStyle() {
        return favoriteClimbingStyle;
    }

    public void setFavoriteClimbingStyle(String favoriteClimbingStyle) {
        this.favoriteClimbingStyle = favoriteClimbingStyle;
    }

    public String getFavoritePersonalities() {
        return favoritePersonalities;
    }

    public void setFavoritePersonalities(String favoritePersonalities) {
        this.favoritePersonalities = favoritePersonalities;
    }

    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
