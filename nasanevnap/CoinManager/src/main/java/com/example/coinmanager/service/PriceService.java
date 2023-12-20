package com.example.coinmanager.service;

import com.example.coinmanager.processengine.ProcessEngine;
import com.example.coinmanager.repository.PriceRepository;
import com.example.coinmanager.service.model.CurrencyPriceData;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    private final ProcessEngine processEngine;
    private final PriceRepository repository;

    public PriceService(ProcessEngine processEngine, PriceRepository repository) {
        this.processEngine = processEngine;
        this.repository = repository;
    }

    @Scheduled(fixedRate = 1000)
    public void processDataStream(String coin) {
        CurrencyPriceData fragment =  processEngine.processResponse("BTC");

        if(fragment != null) {
            repository.save(fragment);
        }
    }
}
