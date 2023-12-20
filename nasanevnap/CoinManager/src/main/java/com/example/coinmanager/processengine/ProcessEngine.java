package com.example.coinmanager.processengine;

import com.example.coinmanager.service.model.CoinApiUrl;
import com.example.coinmanager.service.model.CurrencyPriceData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;

@Component
public class ProcessEngine {
    public CurrencyPriceData processResponse(String coin) {
        CoinApiUrl coinApiUrl = CoinApiUrl.valueOf(coin.toUpperCase() + "_USD_BUY");

        String apiUrlAsString = coinApiUrl.getApiUrl();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(apiUrlAsString);

            JsonNode dataNode = root.path("data");
            String base = dataNode.path("base").asText();
            String currency = dataNode.path("currency").asText();
            Long amount = dataNode.path("amount").asLong();

            return new CurrencyPriceData(base, amount, currency, Instant.now());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
