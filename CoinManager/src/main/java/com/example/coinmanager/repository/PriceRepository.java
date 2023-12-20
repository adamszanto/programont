package com.example.coinmanager.repository;

import com.example.coinmanager.service.model.CurrencyPriceData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<CurrencyPriceData, String> {
}
