package com.example.exchangeratechallenge.services;

import com.example.exchangeratechallenge.models.ExchangeRateConfig;
import com.example.exchangeratechallenge.repos.ExchangeRateConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ExchangeRateConfigServiceImpl implements ExchangeRateConfigService{

    @Autowired
    private ExchangeRateConfigRepository repository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Flux<ExchangeRateConfig> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<ExchangeRateConfig> save(ExchangeRateConfig exchangeRateConfig) {

        LocalDate date = LocalDate.now();

        exchangeRateConfig.setDate(LocalDate.parse(date.format(FORMATTER), FORMATTER).atStartOfDay());
        exchangeRateConfig.setRegistryDate(LocalDate.parse(date.format(FORMATTER), FORMATTER).atStartOfDay());
        // TODO: set registry user
        exchangeRateConfig.setRegistryUser("dummy");

        return repository.save(exchangeRateConfig);
    }

    @Override
    public Mono<ExchangeRateConfig> update(ExchangeRateConfig exchangeRateConfig) {
        LocalDate date = LocalDate.now();

        exchangeRateConfig.setModificationDate(LocalDate.parse(date.format(FORMATTER), FORMATTER).atStartOfDay());
        // TODO: set registry user
        exchangeRateConfig.setModificationUser("dummy-mod");

        return repository.save(exchangeRateConfig);
    }

    @Override
    public Flux<ExchangeRateConfig> findByOriginCurrencyAndDestinyCurrency(String originCurrency, String destinyCurrency) {
        return repository.findByOriginCurrencyAndDestinyCurrency(originCurrency, destinyCurrency);
    }
}
