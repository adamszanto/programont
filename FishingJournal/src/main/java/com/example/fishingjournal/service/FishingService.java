package com.example.fishingjournal.service;

import com.example.fishingjournal.service.model.Fish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FishingService {
    private final Logger logger = LoggerFactory.getLogger(FishingService.class);
    private List<Fish> fishes = new ArrayList<>();
    private final static String TOKEN_VALUE = "1234";
    public boolean isValidAuth(String tokenValue) {
        return tokenValue.equals(TOKEN_VALUE);
    }
}
