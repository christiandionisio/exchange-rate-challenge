package com.example.exchangeratechallenge.services;

import com.example.exchangeratechallenge.models.Exchange;
import com.example.exchangeratechallenge.repos.ExchangeRateConfigRepository;
import com.example.exchangeratechallenge.repos.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ExchangeServiceImpl implements ExchangeService{

    @Autowired
    private ExchangeRepository repository;

    @Autowired
    private ExchangeRateConfigRepository exchangeRateConfigRepository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Flux<Exchange> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Exchange> save(Exchange exchange) {

        LocalDate date = LocalDate.now();

        return exchangeRateConfigRepository.findByOriginCurrencyAndDestinyCurrencyAndDate(exchange.getOriginCurrency(),
                exchange.getDestinyCurrency(), LocalDate.parse(date.format(FORMATTER), FORMATTER).atStartOfDay())
                .flatMap(resp -> {
                    exchange.setExchangedAmount(exchange.getAmount().multiply(resp.getExchangeRate()));
                    exchange.setExchangeRate(resp.getExchangeRate());
                    return repository.save(exchange);
                });
    }
}
