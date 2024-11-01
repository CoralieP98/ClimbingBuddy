package com.CoralieP98.Web_app.Service.Converter;


import com.CoralieP98.Web_app.Model.Technique;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TechniqueConverter implements Converter<String, Technique> {

    private final ClimbFeignClient climbClient;

    public TechniqueConverter(@Lazy ClimbFeignClient climbClient) {
        this.climbClient = climbClient;
    }
    @Override
    public Technique convert(String source) {
        int techniqueId = Integer.parseInt(source);
        return climbClient.findTechniqueById(techniqueId).getBody();
    }
}
