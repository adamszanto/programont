package com.example.coinmanager.controller;

import com.example.coinmanager.processengine.ProcessEngine;
import com.example.coinmanager.service.PriceService;
import com.example.coinmanager.service.model.CoinApiUrl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/price")
public class PriceController {
    private final ProcessEngine processEngine;
    private final PriceService priceService;

    public PriceController(ProcessEngine processEngine, PriceService priceService) {
        this.processEngine = processEngine;
        this.priceService = priceService;
    }

    @GetMapping("/{coin}")
    public ResponseEntity<String> getPrice(@PathVariable String coin) {
        CoinApiUrl coinApiUrl = CoinApiUrl.valueOf(coin.toUpperCase() + "_USD_BUY");

        if (coinApiUrl != null) {
            String apiUrl = coinApiUrl.getApiUrl();
            priceService.setCurrentCoin(coin);
            priceService.processDataStream();
            String message = coin + " stream in progress";
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.badRequest().body("Invalid coin symbol");
        }
    }
}
