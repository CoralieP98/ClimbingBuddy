package com.CoralieP98.Climb.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @NotBlank(message = "UserName is mandatory")
    private String userName;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @Column(unique = true)
    private String email;

    public User() {
    }

    public User(int id, String name, String userName, String password, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
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
