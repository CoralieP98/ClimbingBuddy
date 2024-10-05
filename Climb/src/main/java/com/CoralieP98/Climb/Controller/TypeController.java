package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.Type;
import com.CoralieP98.Climb.Service.TypeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("getAll3Types")
    public List<Type> getAll3Types(){
        return typeService.getAllTypes();
    }

    @GetMapping("getTypeById")
    public Type getTypeById(@RequestParam int typeId){
        return typeService.getTypeById(typeId);
    }
}
