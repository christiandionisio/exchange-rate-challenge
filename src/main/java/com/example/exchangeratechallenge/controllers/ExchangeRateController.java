package com.example.exchangeratechallenge.controllers;

import com.example.exchangeratechallenge.dtos.ExchangeRateConfigDto;
import com.example.exchangeratechallenge.models.ExchangeRateConfig;
import com.example.exchangeratechallenge.security.JWTUtil;
import com.example.exchangeratechallenge.services.ExchangeRateConfigService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateConfigService service;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping
    Flux<ExchangeRateConfig> findAll() {
        return service.getAll();
    }

    @PostMapping
    Mono<ResponseEntity<ExchangeRateConfig>> save(@RequestBody ExchangeRateConfigDto exchangeRateConfigDto,
                                                  @RequestHeader (name="Authorization") String token) {
        String [] arrayAuth = token.split(" ");
        exchangeRateConfigDto.setRegistryUser(jwtUtil.getUsernameFromToken(arrayAuth[1]));
        return service.save(modelMapper.map(exchangeRateConfigDto, ExchangeRateConfig.class))
                .flatMap(resp -> Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(resp)))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping
    Mono<ResponseEntity<ExchangeRateConfig>> update(@RequestBody ExchangeRateConfigDto exchangeRateConfigDto,
                                                    @RequestHeader (name="Authorization") String token) {
        String [] arrayAuth = token.split(" ");
        exchangeRateConfigDto.setModificationUser(jwtUtil.getUsernameFromToken(arrayAuth[1]));
        return service.update(modelMapper.map(exchangeRateConfigDto, ExchangeRateConfig.class))
                .flatMap(resp -> Mono.just(ResponseEntity.status(HttpStatus.OK).body(resp)))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping("/findByCurrency")
    Mono<ResponseEntity<Flux<ExchangeRateConfig>>> findByOriginCurrencyAndDestinyCurrency(
                @Param("originCurrency") String originCurrency,
                @Param("destinyCurrency") String destinyCurrency
            ) {

        return Mono.just(ResponseEntity.ok(service.findByOriginCurrencyAndDestinyCurrency(originCurrency, destinyCurrency)))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
