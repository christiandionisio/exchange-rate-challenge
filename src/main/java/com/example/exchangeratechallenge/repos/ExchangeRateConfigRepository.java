package com.example.exchangeratechallenge.repos;

import com.example.exchangeratechallenge.models.ExchangeRateConfig;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ExchangeRateConfigRepository extends ReactiveCrudRepository<ExchangeRateConfig, Integer> {

}
