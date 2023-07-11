package com.example.fishingjournal.controller;

import com.example.fishingjournal.service.FishingService;
import com.example.fishingjournal.service.model.Fish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public String index(Model model) {
            fishingService.getFishes().sort(Comparator.comparing(Fish::getTimestamp).reversed());
            model.addAttribute("fishes", fishingService.getFishes());
            return "index";

    }

    @PostMapping("/addFish")
    public String addFish(@ModelAttribute Fish fish, Model model) {
        fish.setTimestamp(new Date());
        fishingService.getFishes().add(fish);
        fishingService.getFishes().sort(Comparator.comparing(Fish::getTimestamp).reversed());
        model.addAttribute("fishes", fishingService.getFishes());
        return "index";
    }

    @PostMapping("/deleteFish")
    public String deleteFish(@RequestParam("index") int index, Model model) {
        if(index >= 0 && index < fishingService.getFishes().size()) {
            fishingService.getFishes().remove(index);
        }
        model.addAttribute("fishes", fishingService.getFishes());
        return "index";
    }

}
