package com.CoralieP98.Web_app.Service.Converter;

import com.CoralieP98.Web_app.Model.Exercice;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExerciceConverter implements Converter<String, Exercice> {

    private final ClimbFeignClient climbClient;

    public ExerciceConverter(@Lazy ClimbFeignClient climbClient) {
        this.climbClient = climbClient;
    }

    @Override
    public Exercice convert(String source) {
        int exerciceId = Integer.parseInt(source);
        return climbClient.findExerciceById(exerciceId).getBody();
    }
}
