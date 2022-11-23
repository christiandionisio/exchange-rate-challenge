package com.example.exchangeratechallenge.services;

import com.example.exchangeratechallenge.models.Exchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExchangeService {
    Flux<Exchange> getAll();
    Mono<Exchange> save(Exchange exchange);
}
