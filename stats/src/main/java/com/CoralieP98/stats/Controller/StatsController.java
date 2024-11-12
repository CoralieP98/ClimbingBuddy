package com.CoralieP98.stats.Controller;

import com.CoralieP98.stats.Service.UserStatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    private final UserStatService userStatService;

    public StatsController(UserStatService userStatService) {
        this.userStatService = userStatService;
    }

    @GetMapping("/statWithData")
    public String statWithData(@RequestParam int id,@RequestParam int sessionId) {
        return userStatService.statWithData(id,sessionId);


    }
}
