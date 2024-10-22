package com.CoralieP98.Web_app.Model;

import com.CoralieP98.Web_app.Model.Place;
import com.CoralieP98.Web_app.Model.Session;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class User {


    private int id;

    private String userName;

    private String password;

    private String email;


}

