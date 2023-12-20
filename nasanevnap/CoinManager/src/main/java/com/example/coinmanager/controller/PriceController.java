package com.example.coinmanager.controller;

import com.example.coinmanager.processengine.ProcessEngine;
import com.example.coinmanager.service.PriceService;
import com.example.coinmanager.service.model.CoinApiUrl;
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
    public String getPrice(@PathVariable String coin) {
        CoinApiUrl coinApiUrl = CoinApiUrl.valueOf(coin.toUpperCase() + "_USD_BUY");

        if (coinApiUrl != null) {
            String apiUrl = coinApiUrl.getApiUrl();
            priceService.processDataStream(coin);
            return apiUrl;
        } else {
            return "Invalid coin symbol";
        }
    }
}
