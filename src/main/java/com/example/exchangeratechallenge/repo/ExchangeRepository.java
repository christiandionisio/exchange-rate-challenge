package com.example.exchangeratechallenge.repo;

import com.example.exchangeratechallenge.models.Exchange;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ExchangeRepository extends ReactiveCrudRepository<Exchange, Integer> {
}
