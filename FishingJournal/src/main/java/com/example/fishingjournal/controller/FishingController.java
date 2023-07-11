package com.example.fishingjournal.controller;

import com.example.fishingjournal.service.FishingService;
import com.example.fishingjournal.service.model.Fish;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class FishingController {
    private final FishingService fishingService;
    private final Logger logger = LoggerFactory.getLogger(FishingController.class);

    public FishingController(FishingService fishingService) {
        this.fishingService = fishingService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<Fish> fishes = fishingService.getFishes(session);

        fishes.sort(Comparator.comparing(Fish::getTimestamp).reversed());
        model.addAttribute("fishes", fishes);
        return "index";
    }

    @PostMapping("/addFish")
    public String addFish(@ModelAttribute Fish fish, Model model, HttpSession session) {
        fish.setTimestamp(new Date());
        fishingService.addFish(fish, session);
        List<Fish> fishes = fishingService.getFishes(session);
        fishes.sort(Comparator.comparing(Fish::getTimestamp).reversed());
        model.addAttribute("fishes", fishes);
        return "redirect:/";

    }

    @PostMapping("/deleteFish")
    public String deleteFish(@RequestParam("index") int index, Model model, HttpSession session) {
        fishingService.deleteFish(index, session);
        model.addAttribute("fishes", fishingService.getFishes(session));
        return "redirect:/";
    }
}
