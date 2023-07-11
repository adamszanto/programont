package com.example.fishingjournal.service;

import com.example.fishingjournal.service.model.Fish;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FishingService {
    private final Logger logger = LoggerFactory.getLogger(FishingService.class);
    public List<Fish> getFishes(HttpSession session) {
        List<Fish> fishes = (List<Fish>)session.getAttribute("fishes");
        if(fishes == null) {
            fishes = new ArrayList<>();
            session.setAttribute("fishes", fishes);
        }
        return fishes;
    }

    public void addFish(Fish fish, HttpSession session) {
        fish.setTimestamp(new Date());
        getFishes(session).add(fish);
    }

    public void deleteFish(int index, HttpSession session) {
        List<Fish> fishes = getFishes(session);
        if(index >= 0 && index < fishes.size()) {
            fishes.remove(index);
        }
    }
}
