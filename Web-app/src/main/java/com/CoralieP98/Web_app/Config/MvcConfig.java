package com.CoralieP98.Web_app.Config;

import com.CoralieP98.Web_app.Service.Converter.ExerciceConverter;
import com.CoralieP98.Web_app.Service.Converter.TechniqueConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/loadingPage").setViewName("loading");
        registry.addViewController("/login").setViewName("signIn");

    }

    private final ExerciceConverter exerciceConverter;

    private final TechniqueConverter techniqueConverter;

    public MvcConfig(ExerciceConverter exerciceConverter, TechniqueConverter techniqueConverter) {
        this.exerciceConverter = exerciceConverter;
        this.techniqueConverter = techniqueConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(exerciceConverter);
        registry.addConverter(techniqueConverter);
    }
}
