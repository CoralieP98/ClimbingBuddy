package com.CoralieP98.stats.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    @GetMapping("/statWithData")
    public String statWithData(@RequestParam int id) {

    }
}
