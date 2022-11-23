package com.example.exchangeratechallenge.repos;

import com.example.exchangeratechallenge.models.ExchangeRateConfig;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface ExchangeRateConfigRepository extends ReactiveCrudRepository<ExchangeRateConfig, Integer> {

    Flux<ExchangeRateConfig> findByOriginCurrencyAndDestinyCurrency(String originCurrency, String destinyCurrency);
    Mono<ExchangeRateConfig> findByOriginCurrencyAndDestinyCurrencyAndDate(String originCurrency,
                                                                           String destinyCurrency,
                                                                           LocalDateTime date);

}
