package com.example.fishingjournal.service;

import com.example.fishingjournal.service.model.Fish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FishingService {
    private final Logger logger = LoggerFactory.getLogger(FishingService.class);
    private List<Fish> fishes = new ArrayList<>();

    public List<Fish> getFishes() {
        return fishes;
    }

    public void addFish(Fish fish) {
        fish.setTimestamp(new Date());
        fishes.add(fish);
    }

    public void deleteFish(int index) {
        if(index >= 0 && index < fishes.size()) {
            fishes.remove(index);
        }
    }
}
