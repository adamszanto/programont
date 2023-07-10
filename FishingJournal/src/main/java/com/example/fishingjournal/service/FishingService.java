package com.example.fishingjournal.service;

import org.springframework.stereotype.Service;

@Service
public class FishingService {
    private final static String TOKEN_VALUE = "1337tokenvalue";
    public boolean isValidAuth(String tokenValue) {
        return tokenValue.equals(TOKEN_VALUE);
    }
}
