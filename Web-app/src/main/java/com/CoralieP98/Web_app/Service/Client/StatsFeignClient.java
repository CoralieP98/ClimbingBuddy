package com.CoralieP98.Web_app.Service.Client;

import com.CoralieP98.Web_app.Model.ExerciceCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("stats")
public interface StatsFeignClient {

    @GetMapping(value = "/statWithData", consumes = "application/json")
    public ResponseEntity<String> statWithData(@RequestParam int id, @RequestParam int sessionId);
}
