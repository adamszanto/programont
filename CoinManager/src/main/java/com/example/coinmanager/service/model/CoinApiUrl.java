package com.example.coinmanager.service.model;

public enum CoinApiUrl {
    BTC_USD_BUY("https://api.coinbase.com/v2/prices/BTC-USD/buy"),
    ETH_USD_BUY("https://api.coinbase.com/v2/prices/ETH-USD/buy");

    private final String apiUrl;

    CoinApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }
}
