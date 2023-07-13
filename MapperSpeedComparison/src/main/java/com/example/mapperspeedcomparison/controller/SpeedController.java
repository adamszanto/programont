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
import java.io.FileWriter;
import java.io.IOException;

import static com.example.mapperspeedcomparison.service.SpeedService.RACE_LAPS;

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
        long seconds = duration.getSeconds();
        long millis = duration.toMillis() % 1000;
        String result = "ModelMapper's speed test for " + RACE_LAPS + " mapping completed in " + seconds + "." + millis + " seconds";
        speedService.writeResultToFile("modelmapper_result.txt", result);
        speedService.deleteAllEntries();
        return result;
    }

    @PostMapping("/mapstructrace")
    public String mapStructRace() {
        Instant start = Instant.now();

        List<Node> mapStructNodes = new ArrayList<>();
        speedService.raceMapStruct(mapStructNodes);
        Instant finish = Instant.now();
        Duration duration = Duration.between(start, finish);
        long seconds = duration.getSeconds();
        long millis = duration.toMillis() % 1000;
        String result = "MapStruct's speed test for " + RACE_LAPS + " mapping completed in " + seconds + "." + millis + " seconds";
        speedService.writeResultToFile("mapstruct_result.txt", result);
        speedService.deleteAllEntries();
        return result;
    }
}
