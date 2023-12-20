package com.example.coinmanager.service;

import com.example.coinmanager.processengine.ProcessEngine;
import com.example.coinmanager.repository.PriceRepository;
import com.example.coinmanager.service.model.CurrencyPriceData;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    private static final Logger logger = LoggerFactory.getLogger(PriceService.class);
    private final ProcessEngine processEngine;
    private final PriceRepository repository;
    private String currentCoin;
    private boolean scheduledProcessingEnabled = false;

    public PriceService(ProcessEngine processEngine, PriceRepository repository) {
        this.processEngine = processEngine;
        this.repository = repository;
    }


    @Scheduled(fixedRate = 100)
    public void processDataStream() {
        if (currentCoin == null) {
            logger.info("Initial processing not completed. Skipping scheduled task.");
            return;
        }

        CurrencyPriceData fragment = processEngine.processResponse(currentCoin);

        if (fragment != null) {
            repository.save(fragment);
            logger.info("{} data saved", currentCoin);
        }
    }

    public String getCurrentCoin() {
        return currentCoin;
    }

    public void setCurrentCoin(String coin) {
        this.currentCoin = coin;
    }
}
