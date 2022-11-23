package com.example.exchangeratechallenge.repos;

import com.example.exchangeratechallenge.models.Exchange;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ExchangeRepository extends ReactiveCrudRepository<Exchange, Integer> {
}
