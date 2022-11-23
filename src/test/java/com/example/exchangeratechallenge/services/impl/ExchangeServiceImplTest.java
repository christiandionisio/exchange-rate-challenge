package com.example.exchangeratechallenge.services.impl;

import com.example.exchangeratechallenge.models.Exchange;
import com.example.exchangeratechallenge.models.ExchangeRateConfig;
import com.example.exchangeratechallenge.repo.ExchangeRateConfigRepository;
import com.example.exchangeratechallenge.repo.ExchangeRepository;
import com.example.exchangeratechallenge.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ExchangeServiceImplTest {

    @MockBean
    private ExchangeRepository repo;

    @MockBean
    private ExchangeRateConfigRepository exchangeRateConfigRepository;

    @Autowired
    private ExchangeServiceImpl exchangeServiceImpl;

    @Test
    void getAll() {
        Mockito.when(repo.findAll())
                .thenReturn(Flux.fromIterable(getExchangeListMock()));

        StepVerifier.create(exchangeServiceImpl.getAll())
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void save() {
        Mockito.when(repo.save(Mockito.any()))
                .thenReturn(Mono.just(getExchangeMock()));

        Mockito.when(exchangeRateConfigRepository.findByOriginCurrencyAndDestinyCurrencyAndDate(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(Mono.just(getExchangeRateConfigMock()));

        StepVerifier.create(exchangeServiceImpl.save(getExchangeMock()))
                .expectNextCount(1)
                .verifyComplete();
    }

    List<Exchange> getExchangeListMock() {
        List<Exchange> exchangeList = new ArrayList<>();

        Exchange exchange1 = new Exchange();
        exchange1.setExchangedAmount(new BigDecimal(12.99));
        exchange1.setOriginCurrency("PEN");
        exchange1.setDestinyCurrency("USD");

        Exchange exchange2 = new Exchange();
        exchange2.setExchangedAmount(new BigDecimal(22.99));
        exchange2.setOriginCurrency("PEN");
        exchange2.setDestinyCurrency("EUR");

        exchangeList.add(exchange1);
        exchangeList.add(exchange2);

        return exchangeList;
    }

    Exchange getExchangeMock() {

        Exchange exchange1 = new Exchange();
        exchange1.setExchangedAmount(new BigDecimal(12.99));
        exchange1.setAmount(new BigDecimal(12.99));
        exchange1.setExchangeRate(new BigDecimal(2.99));
        exchange1.setOriginCurrency("PEN");
        exchange1.setDestinyCurrency("USD");

        return exchange1;
    }

    ExchangeRateConfig getExchangeRateConfigMock() {

        ExchangeRateConfig exchange = new ExchangeRateConfig();
        exchange.setExchangeRate(new BigDecimal(2.99));
        exchange.setOriginCurrency("PEN");
        exchange.setDestinyCurrency("USD");

        return exchange;
    }

}