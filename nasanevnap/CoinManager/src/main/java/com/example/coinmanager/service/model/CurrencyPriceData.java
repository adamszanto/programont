package com.example.coinmanager.service.model;

import java.time.Instant;

public class CurrencyPriceData {
    private String base;
    private long amount;
    private String currency;
    private Instant timestamp;

    public CurrencyPriceData(String base, long amount, String currency, Instant timestamp) {
        this.base = base;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = timestamp;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CurrencyPriceData{" +
                "base='" + base + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
