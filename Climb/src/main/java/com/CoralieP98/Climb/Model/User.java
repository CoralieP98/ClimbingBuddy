package com.CoralieP98.Climb.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "UserName is mandatory")
    private String userName;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Session> sessions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Place> favoritesPlaces;

    public User() {
    }

    public User(int id, String userName, String password, String email, List<Session> sessions, List<Place> favoritesPlaces) {
        this.id = id;
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
