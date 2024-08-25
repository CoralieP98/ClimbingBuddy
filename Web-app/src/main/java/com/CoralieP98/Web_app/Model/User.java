package com.CoralieP98.Web_app.Model;

import com.CoralieP98.Web_app.Model.Place;
import com.CoralieP98.Web_app.Model.Session;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class User {


    private int id;

    private String name;

    private String userName;

    private String password;

    private String email;

    private List<Session> sessions;

    private List<Place> favoritesPlaces;

    public User() {
    }

    public User(int id, String name, String userName, String password, String email, List<Session> sessions, List<Place> favoritesPlaces) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.sessions = sessions;
        this.favoritesPlaces = favoritesPlaces;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public List<Place> getFavoritesPlaces() {
        return favoritesPlaces;
    }

    public void setFavoritesPlaces(List<Place> favoritesPlaces) {
        this.favoritesPlaces = favoritesPlaces;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public User(List<Session> sessions) {
        this.sessions = sessions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @NotBlank(message = "UserName is mandatory") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "UserName is mandatory") String userName) {
        this.userName = userName;
    }

    public @NotBlank(message = "Password is mandatory") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
