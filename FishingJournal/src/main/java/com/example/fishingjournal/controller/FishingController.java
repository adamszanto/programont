package com.example.fishingjournal.controller;

import com.example.fishingjournal.service.model.Fish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class FishingController {
    private List<Fish> fishes = new ArrayList<>();

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

}
