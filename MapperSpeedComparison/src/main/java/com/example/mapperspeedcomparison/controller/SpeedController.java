package com.example.mapperspeedcomparison.controller;

import com.example.mapperspeedcomparison.service.Node;
import com.example.mapperspeedcomparison.service.SpeedService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/speed")
public class SpeedController {
    private final SpeedService speedService;

    public SpeedController(SpeedService speedService) {
        this.speedService = speedService;
    }

    @PostMapping("/modelmapperrace")
    public String modelMapperRace() {
        Instant start = Instant.now();

        List<Node> modelMapperNodes = new ArrayList<>();
        speedService.raceModelMapper(modelMapperNodes);
        Instant finish = Instant.now();
        Duration duration = Duration.between(start, finish);

        return "Model Mapper's race completed in " + duration.toMillis() + " milliseconds";
    }

    @PostMapping("/mapstructrace")
    public String mapStructRace() {
        Instant start = Instant.now();

        List<Node> mapStructNodes = new ArrayList<>();
        speedService.raceMapStruct(mapStructNodes);
        Instant finish = Instant.now();
        Duration duration = Duration.between(start, finish);

        return "MapStruct's race completed in " + duration.toMillis() + " milliseconds";
    }
}
