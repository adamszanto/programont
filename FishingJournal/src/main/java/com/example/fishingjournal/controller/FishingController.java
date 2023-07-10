package com.example.fishingjournal.controller;

import com.example.fishingjournal.service.FishingService;
import com.example.fishingjournal.service.model.Fish;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class FishingController {
    private final FishingService fishingService;
    private List<Fish> fishes = new ArrayList<>();

    private final static String AUTH_FAILED = "Authentication failed.";
    private final static String AUTH_SUCCESS = "Authentication success";

    public FishingController(FishingService fishingService) {
        this.fishingService = fishingService;
    }

    @GetMapping("/")
    public String index(Model model) {
        fishes.sort(Comparator.comparing(Fish::getTimestamp).reversed());
        model.addAttribute("fishes", fishes);
        return "index";
    }

    @PostMapping("/addFish")
    public String addFish(@ModelAttribute Fish fish) {
        fish.setTimestamp(new Date());
        fishes.add(fish);
        return "redirect:/";
    }

    @PostMapping("/deleteFish")
    public String deleteFish(@RequestParam("index") int index) {
        if(index >= 0 && index < fishes.size()) {
            fishes.remove(index);
        }
        return "redirect:/";
    }

    @GetMapping("/auth")
    public ResponseEntity<?> authentication(@RequestHeader String token) {
        String response = AUTH_SUCCESS;
        if (fishingService.isValidAuth(token)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else {
            response = AUTH_FAILED;
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}
