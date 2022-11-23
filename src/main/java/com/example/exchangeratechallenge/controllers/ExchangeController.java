package com.example.exchangeratechallenge.controllers;

import com.example.exchangeratechallenge.dtos.ExchangeDto;
import com.example.exchangeratechallenge.models.Exchange;
import com.example.exchangeratechallenge.services.ExchangeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/exchanges")
public class ExchangeController {

    @Autowired
    private ExchangeService service;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    Mono<ResponseEntity<Flux<Exchange>>> getAll() {
        return Mono.just(ResponseEntity.ok(service.getAll()));
    }

    @PostMapping
    Mono<ResponseEntity<Exchange>> save(@RequestBody @Valid ExchangeDto exchangeDto) {
        return service.save(modelMapper.map(exchangeDto, Exchange.class))
                .flatMap(resp -> Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(resp)))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

}
