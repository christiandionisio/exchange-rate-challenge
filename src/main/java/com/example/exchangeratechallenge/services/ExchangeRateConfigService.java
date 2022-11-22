package com.example.exchangeratechallenge.services;

import com.example.exchangeratechallenge.models.ExchangeRateConfig;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExchangeRateConfigService {
    Flux<ExchangeRateConfig> getAll();
    Mono<ExchangeRateConfig> save(ExchangeRateConfig exchangeRateConfig);
    Mono<ExchangeRateConfig> update(ExchangeRateConfig exchangeRateConfig);
}
